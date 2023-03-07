import { Component } from '@angular/core';
import {ApiService} from "./service/api.service";
import {User} from "./model/User";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'frontend';
  form: FormGroup;


  constructor(private api: ApiService, private fb: FormBuilder) {
    this.form = this.fb.group({
      username: ['',Validators.required],
      password: ['',Validators.required]
    });
  }

  createUser(){
    // stop here if form is invalid
    if (this.form.invalid) {
      return;
    }

   const user: User = {
      username: this.form.controls["username"].value,
      password: this.form.controls["password"].value
    }
  this.api.createUser(user);
  }

}
