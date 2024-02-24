import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OptionServiceService {

  constructor(private http: HttpClient) { }

  private baseUrl = 'http://localhost:8099/api/Option';
  private apiAddOption = 'http://localhost:8099/api/Option/addOption';
  private apiDeleteOption = 'http://localhost:8099/api/Option/Delete';
  private apiUpdateOption = 'http://localhost:8099/api/Option/UpdateOption';
  private apiGetOptions = 'http://localhost:8099/api/Option/retrieve-all';
  private apiGetOptionById = 'http://localhost:8099/api/Option/retrieve-all/{{Option-Id}}';

  createOption(Option: any): Observable<any> { 
    return this.http.post(this.apiAddOption, Option);
  }

  deleteOption(OptionId: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/Delete/${OptionId}`, { responseType: 'text' });
  }

  updateOption(OptionId: string, OptionData: any): Observable<any> {
    return this.http.put(this.apiUpdateOption, OptionData); 
}


  getOptions(): Observable<any> {
    return this.http.get(this.apiGetOptions);
  }

  getOptionById(OptionId: string): Observable<any> {
    const url = `${this.apiGetOptionById}/${OptionId}`; 
    return this.http.get(url);
  }
}
