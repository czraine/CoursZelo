import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './Shared/nav/nav.component';
import { FooterComponent } from './Shared/footer/footer.component';
import { CourselComponent } from './coursel/coursel.component';

@NgModule({
  declarations: [AppComponent, NavComponent, FooterComponent, CourselComponent],
  imports: [BrowserModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
