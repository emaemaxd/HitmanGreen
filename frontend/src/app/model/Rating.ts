import {Auftrag} from "./Auftrag";
import {Hitman} from "./Hitman";

export interface Rating {
  date: Date;
  stars: number;
  description: string;
  auftrag: Auftrag;
  hitman: Hitman;
}
