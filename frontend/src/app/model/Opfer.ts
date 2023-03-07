import {Auftrag} from "./Auftrag";

export interface Opfer {
  firstname: string;
  lastname: string;
  address: string;
  zip: number;
  city: string;
  country: string;
  age: number;
  socialMedia: string[];
  auftraege: Auftrag[];
}
