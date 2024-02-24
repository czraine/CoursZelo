import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceModuleService {

  constructor(private http: HttpClient) { }

  private baseUrl = 'http://localhost:8099/api/Module';
  private apiAddModule = 'http://localhost:8099/api/Module/addModule';
  private apiDeleteModule = 'http://localhost:8099/api/Module/Delete';
  private apiUpdateModule = 'http://localhost:8099/api/Module/UpdateModule';
  private apiGetModules = 'http://localhost:8099/api/Module/retrieve-all';
  private apiGetModuleById = 'http://localhost:8099/api/Module/retrieve-all/{{Module-Id}}';

  createModule(module: any): Observable<any> { 
    return this.http.post(this.apiAddModule, module);
  }

  deleteModule(moduleId: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/Delete/${moduleId}`, { responseType: 'text' });
  }

  updateModule(moduleId: string, moduleData: any): Observable<any> {
    return this.http.put(this.apiUpdateModule, moduleData); // Enlever moduleId de l'URL
}


  getModules(): Observable<any> {
    return this.http.get(this.apiGetModules);
  }

  getModuleById(moduleId: string): Observable<any> {
    const url = `${this.apiGetModuleById}/${moduleId}`; 
    return this.http.get(url);
  }
}
