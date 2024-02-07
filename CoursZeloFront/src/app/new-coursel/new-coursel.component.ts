import { Component } from '@angular/core';
import {
  NgbCarouselConfig,
  NgbCarouselModule,
} from '@ng-bootstrap/ng-bootstrap';
import { NgIf, NgFor } from '@angular/common';

@Component({
  selector: 'app-new-coursel',
  standalone: true,
  imports: [NgbCarouselModule, NgIf, NgFor],
  templateUrl: './new-coursel.component.html',
  providers: [NgbCarouselConfig],
  styleUrls: ['./new-coursel.component.css'],
})
export class NewCourselComponent {
  images = [
    '../../assets/img/carousel-1.jpg',
    '../../assets/img/carousel-2.jpg',
  ];
  services = [
    {
      title: 'Skilled Instructors',
      iconClass: 'fa fa-graduation-cap',
      description:
        'Diam elitr kasd sed at elitr sed ipsum justo dolor sed clita amet diam',
    },
    {
      title: 'Online Classes',
      iconClass: 'fa fa-globe',
      description:
        'Diam elitr kasd sed at elitr sed ipsum justo dolor sed clita amet diam',
    },
    {
      title: 'Home Projects',
      iconClass: 'fa fa-home',
      description:
        'Diam elitr kasd sed at elitr sed ipsum justo dolor sed clita amet diam',
    },
    {
      title: 'Book Library',
      iconClass: 'fa fa-book-open',
      description:
        'Diam elitr kasd sed at elitr sed ipsum justo dolor sed clita amet diam',
    },
  ];

  constructor(config: NgbCarouselConfig) {
    // customize default values of carousels used by this component tree
    config.interval = 20000;
    config.wrap = true; // Enable wrapping
    config.keyboard = false;
    config.pauseOnHover = false;
  }
}
