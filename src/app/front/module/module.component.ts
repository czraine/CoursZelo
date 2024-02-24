import { Component } from '@angular/core';
import { ServiceModuleService } from 'src/app/services/service-module.service'; 
import { Router } from '@angular/router';

@Component({
  selector: 'app-module',
  templateUrl: './module.component.html',
  styleUrls: ['./module.component.css']
})
export class ModuleComponent {
  
  
  constructor(private serviceModule: ServiceModuleService, private router: Router){}
  module = {
    nameModule: '',
    credit: ''
   
  };
  addModule() : void {
    
      this.serviceModule.createModule(this.module).subscribe(response => {
        console.log('Module Added successfully', response);
        this.router.navigate(['/moduleList']);
      }, error => {
        console.error('There was an error!', error);
      });
    }

    

    

    

}
