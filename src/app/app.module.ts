import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './Shared/nav/nav.component';
import { FooterComponent } from './Shared/footer/footer.component';
import { CourselComponent } from './coursel/coursel.component';
import { CoursesCategoriesComponent } from './front/courses-categories/courses-categories.component';
import { CoursesComponent } from './front/courses/courses.component';
import { TeamComponent } from './front/team/team.component';
import { TestComponent } from './front/test/test.component';
import { AboutComponent } from './front/about/about.component';
//import { ServicesComponent } from './front/services/services.component';
import { CoursesManagerComponent } from './front/courses-manager/courses-manager.component';
import { RouterModule, Routes } from '@angular/router';
import { ContactComponent } from './front/contact/contact.component';
import { NotFoundComponent } from './front/not-found/not-found.component';
import { UniversityComponent } from './front/university/university.component';
import { HttpClientModule } from '@angular/common/http'

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ModuleComponent } from './front/module/module.component';
import { ModuleListComponent } from './front/module-list/module-list.component';
import { OptionAddComponent } from './front/option-add/option-add.component';
import { OptionListComponent } from './front/option-list/option-list.component';
import { QuestionComponent } from './Questions/question/question.component';
import { QuizListComponent } from './QuizList/quiz-list/quiz-list.component';
import { QuizTakeComponent } from './QuizTake/quiz-take/quiz-take.component';
import { CreateQuizComponent } from './Quiz/create-quiz/create-quiz.component';
import { AttemptComponent } from './Attempt/attempts/attempts.component';
//import { FileUploadModule } from 'primeng/fileupload';
const routes: Routes = [
  //{path:'', redirectTo:'CourselComponent', pathMatch:'full'},
  //{path:"**" ,redirectTo : "Home"},
  {path:"CoursManager", component:CoursesManagerComponent},
  {path:"About",  component:AboutComponent},
  //{path:"Services", component:ServicesComponent},
  {path:"Testimonials", component:TestComponent},
  {path:"Team", component:TeamComponent},
  {path:"any",component:CourselComponent},
  {path:"ContactUs", component:ContactComponent},
  {path:"NotFound",component:NotFoundComponent},
  {path:"Home",component:CourselComponent},
  {path:"University", component:UniversityComponent},
  {path:"Module", component:ModuleComponent},
  {path:"moduleList", component:ModuleListComponent},
  {path:"optionAdd", component:OptionAddComponent},
  {path:"optionList", component:OptionListComponent},
  {path:"QUIZAdd",component:CreateQuizComponent},
  {path:"quiz-list",component:QuizListComponent},
  {path:"Question",component:QuestionComponent},
  //{path:"Attemp",component:AttemptsComponent}
  { path: 'quiz/:id', component: AttemptComponent },
  {path:"QuizAttemp", component: AttemptComponent}

    
  

];


@NgModule({
  declarations: [AppComponent, NavComponent, FooterComponent, CourselComponent,
    CoursesCategoriesComponent,CoursesComponent,TeamComponent,TestComponent,
    AboutComponent,CoursesManagerComponent,ContactComponent,
    ContactComponent,NotFoundComponent,UniversityComponent,ModuleComponent,
    ModuleListComponent,OptionAddComponent,OptionListComponent,
    QuestionComponent,QuizListComponent,QuizTakeComponent,CreateQuizComponent,AttemptComponent],
  imports: [BrowserModule,RouterModule.forRoot(routes),HttpClientModule,FormsModule,ReactiveFormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
