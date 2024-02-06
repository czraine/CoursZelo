import { Component } from '@angular/core';
import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-coursel',
  templateUrl: './coursel.component.html',
  styleUrls: ['./coursel.component.css'],
})
export class CourselComponent {
  images = [
    '../../assets/img/carousel-1.jpg',
    '../../assets/img/carousel-2.jpg',
  ];

  constructor(config: NgbCarouselConfig) {
    // customize default values of carousels used by this component tree
    config.interval = 10000;
    config.wrap = false;
    config.keyboard = false;
    config.pauseOnHover = false;
  }
}
