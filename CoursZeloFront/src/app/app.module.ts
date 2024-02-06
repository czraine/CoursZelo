import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { NgbCarouselModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './Shared/nav/nav.component';
import { FooterComponent } from './Shared/footer/footer.component';
import { CourselComponent } from './coursel/coursel.component';
import { NgbCarouselConfig, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NewCourselComponent } from './new-coursel/new-coursel.component';
@NgModule({
  declarations: [AppComponent, NavComponent, FooterComponent, CourselComponent],
  imports: [BrowserModule, AppRoutingModule, NewCourselComponent, NgbModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
