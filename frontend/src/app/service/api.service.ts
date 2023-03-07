import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {map, Observable} from "rxjs";
import {User} from "../model/User";
import {Auftrag} from "../model/Auftrag";
import { MatCheckbox } from '@angular/material/checkbox';
import {Opfer} from "../model/Opfer";
import {Hitman} from "../model/Hitman";


@Injectable({
  providedIn: 'root'
})
export class ApiService {

  apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient, private router: Router) { }


  createUser(user: User) {
    return this.http.post<any>(this.apiUrl + "/user/create", user).subscribe(data => console.log(data))
  }
  login(username: any, password: any) {
    return this.http.post<any>(this.apiUrl + `/user/login/${username}/${password}`, {username, password});
  }

  addAuftrag(opfer: Opfer, auftrag: Auftrag): Observable<any> {
    return this.http.post<any>(
      `${this.apiUrl}/order/create`, { opfer, auftrag });
  }

  getHitmen(): Observable<Hitman[]> {
    return this.http.get<Hitman[]>(this.apiUrl+`/hitman`);
  }

}
