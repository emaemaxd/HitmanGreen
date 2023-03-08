import {Opfer} from "./Opfer";

export interface Auftrag {
  successful: boolean;
  price: number;
  description: string;
  deadline: Date;
  proof: any;
  acceptedByHitman: boolean;
  proofAcceptedByUser: boolean;
  opfer: Opfer;
}
