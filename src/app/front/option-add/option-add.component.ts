import { Component } from '@angular/core';
import { OptionServiceService } from 'src/app/servicesOption/option-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-option-add',
  
  templateUrl: './option-add.component.html',
  styleUrls: ['./option-add.component.css']
})
export class OptionAddComponent {

  constructor(private serviceOption: OptionServiceService, private router: Router){}
  option = {
    nameOption: '',
    mailOption: ''
   
  };
  addOption() : void {
    
      this.serviceOption.createOption(this.option).subscribe(response => {
        console.log('Option Added successfully', response);
        this.router.navigate(['/optionList']);
      }, error => {
        console.error('There was an error!', error);
      });
    }


}
  

    

    


