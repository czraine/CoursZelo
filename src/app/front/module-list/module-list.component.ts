import { Component } from '@angular/core';
import { ServiceModuleService } from 'src/app/services/service-module.service';
import { ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-module-list',
  templateUrl: './module-list.component.html',
  styleUrls: ['./module-list.component.css']
})
export class ModuleListComponent {
  list: any[] = [];
  modalDisplay = false;
  currentModule: any = null;
  modalMode: 'edit' | 'view' = 'view';

  constructor(private cdRef: ChangeDetectorRef, private serviceModule: ServiceModuleService) {}

  ngOnInit(): void {
    this.getAllModules();
  }

  openModal(module: any, mode: 'edit' | 'view' = 'view'): void {
    this.currentModule = module;
    this.modalMode = mode;
    this.modalDisplay = true;
  }

  closeModal(): void {
    this.modalDisplay = false;
  }

  saveChanges(): void {
    if (!this.currentModule || !this.currentModule.idModule) {
      console.log("No module selected or module ID is missing");
      return;
    }
    this.updateModule(this.currentModule.idModule, this.currentModule);
  }

  confirmDelete(moduleId: string): void {
    const isConfirmed = confirm('Are you sure you want to delete this module?');
    if (isConfirmed) {
      this.deleteModule(moduleId);
    }
  }

  deleteModule(moduleId: string): void {
    this.serviceModule.deleteModule(moduleId).subscribe({
      next: () => { 
        alert(moduleId)
        console.log("Module deleted successfully");
        this.getAllModules();
      },
      error: (error) => {
        console.error("Error deleting module", error);
      }
    });
  }

  getAllModules(): void {
    this.serviceModule.getModules().subscribe({
      next: (modules) => {
        this.list = modules;
        console.log('List of Modules updated:', this.list);
        this.cdRef.detectChanges();
      },
      error: (error) => {
        console.error('Error fetching modules', error);
      }
    });
  }

  updateModule(moduleId: string, newData: any): void {
    this.serviceModule.updateModule(moduleId, newData).subscribe({
      next: (response) => {
        console.log('Module Updated successfully', response);
        this.getAllModules();
      },
      error: (error) => {
        console.error('There was an error!', error);
      }
    });
  }

  getModuleById(moduleId: string): void {
    this.serviceModule.getModuleById(moduleId).subscribe({
      next: (module) => {
        console.log('Module Details:', module);
        this.currentModule = module;
      },
      error: (error) => {
        console.error('There was an error!', error);
      }
    });
  }

  selectModuleForEdit(moduleId: string): void {
    this.getModuleById(moduleId);
    this.openModal(this.currentModule, 'edit');
  }
}
