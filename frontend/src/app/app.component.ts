import { Component } from '@angular/core';
import {ApiService} from "./service/api.service";
import {User} from "./model/User";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Auftrag} from "./model/Auftrag";
import {Opfer} from "./model/Opfer";
import {Hitman} from "./model/Hitman";



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'frontend';
  form: FormGroup;
  selectedOption: string = "true";

  hitmen: Hitman[];

  constructor(private api: ApiService, private fb: FormBuilder) {
    this.form = this.fb.group({
      username: ['',Validators.required],
      password: ['',Validators.required],
    });
    this.hitmen = [];
  }


  createAuftragForm() {
    this.form = this.fb.group({
      successful: [true, Validators.required],
      price: [0, Validators.required],
      description: ['', Validators.required],
      deadline: [new Date(), Validators.required],
      proof: [''],
      acceptedByHitman: [true, Validators.required],
      proofAcceptedByUser: [true, Validators.required],
      firstname: ['', Validators.required],
      lastname: ['', Validators.required],
      address: ['', Validators.required],
      zip: ['', Validators.required],
      city: ['', Validators.required],
      country: ['', Validators.required],
      age: [0],
      socialMedia: ['']
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

  login(username: any, password: any){
    // stop here if form is invalid
    if (this.form.invalid) {
      return;
    }

    username = this.form.controls["username"].value;
    password = this.form.controls["password"].value;

    this.api.login(username, password).subscribe(o => {
      console.log(o);
    });
  }



  addAuftrag(): void {
    if (this.form.invalid) {
      return;
    }

    const opfer: Opfer = {
      firstname: this.form.controls["firstname"].value,
      lastname: this.form.controls["lastname"].value,
      address: this.form.controls["address"].value,
      zip: this.form.controls["zip"].value,
      city: this.form.controls["city"].value,
      country: this.form.controls["country"].value,
      age: this.form.controls["age"].value,
      socialMedia: this.form.controls["socialMedia"].value,
    }

    const auftrag: Auftrag = {
      successful: this.form.controls["successful"].value,
      price: this.form.controls["price"].value,
      description: this.form.controls["description"].value,
      deadline: this.form.controls["deadline"].value,
      proof: this.form.controls["proof"].value,
      acceptedByHitman: this.form.controls["acceptedByHitman"].value,
      proofAcceptedByUser: this.form.controls["proofAcceptedByUser"].value,
      opfer: opfer
    };





    this.api.addAuftrag(auftrag.opfer, auftrag).subscribe(o => {
      console.log(o);
    });
  }

  ngOnInit() {
    this.api.getHitmen()
      .subscribe(hitmen => this.hitmen = hitmen);
  }

  getHitmen(): void {
    this.api.getHitmen()
      .subscribe(hitmen => this.hitmen = hitmen);
  }



}
