import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {map} from "rxjs";
import {User} from "../model/User";

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient, private router: Router) { }



  createUser(user: User) {
    return this.http.post<any>(this.apiUrl + "/user/create", user).subscribe(data => console.log(data))
  }
}
