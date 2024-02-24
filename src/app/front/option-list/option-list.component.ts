import { Component } from '@angular/core';
import { ChangeDetectorRef } from '@angular/core';
import { OptionServiceService } from 'src/app/servicesOption/option-service.service';
@Component({
  selector: 'app-option-list',
  templateUrl: './option-list.component.html',
  styleUrls: ['./option-list.component.css']
})
export class OptionListComponent {
  list: any[] = [];
  modalDisplay = false;
  currentOption: any = null;
  modalMode: 'edit' | 'view' = 'view';

  constructor(private cdRef: ChangeDetectorRef, private serviceOption: OptionServiceService) {}

  ngOnInit(): void {
    this.getAllOptions();
  }

  openModal(option: any, mode: 'edit' | 'view' = 'view'): void {
    this.currentOption = option;
    this.modalMode = mode;
    this.modalDisplay = true;
  }

  closeModal(): void {
    this.modalDisplay = false;
  }

  saveChanges(): void {
    if (!this.currentOption || !this.currentOption.idOption) {
      console.log("No option selected or option ID is missing");
      return;
    }
    this.updateOption(this.currentOption.idOption, this.currentOption);
  }

  confirmDelete(optionId: string): void {
    const isConfirmed = confirm('Are you sure you want to delete this option?');
    if (isConfirmed) {
      this.deleteOption(optionId);
    }
  }

  deleteOption(optionId: string): void {
    this.serviceOption.deleteOption(optionId).subscribe({
      next: () => { 
        alert(optionId)
        console.log("Option deleted successfully");
        this.getAllOptions();
      },
      error: (error) => {
        console.error("Error deleting optionId", error);
      }
    });
  }

  getAllOptions(): void {
    this.serviceOption.getOptions().subscribe({
      next: (options) => {
        this.list = options;
        console.log('List of Options updated:', this.list);
        this.cdRef.detectChanges();
      },
      error: (error) => {
        console.error('Error fetching options', error);
      }
    });
  }

  updateOption(optionId: string, newData: any): void {
    this.serviceOption.updateOption(optionId, newData).subscribe({
      next: (response) => {
        console.log('Option Updated successfully', response);
        this.getAllOptions();
      },
      error: (error) => {
        console.error('There was an error!', error);
      }
    });
  }

  getOptionById(optionId: string): void {
    this.serviceOption.getOptionById(optionId).subscribe({
      next: (option) => {
        console.log('Option Details:', option);
        this.currentOption = optionId;
      },
      error: (error) => {
        console.error('There was an error!', error);
      }
    });
  }

  selectOptionForEdit(optionId: string): void {
    this.getOptionById(optionId);
    this.openModal(this.currentOption, 'edit');
  }
}
