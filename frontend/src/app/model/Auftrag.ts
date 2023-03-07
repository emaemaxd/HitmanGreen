export interface Auftrag {
  order_id: number;
  successful: boolean;
  price: number;
  description: string;
  deadline: Date;
  proof: Blob[];
  acceptedByHitman: boolean;
  proofAcceptedByUser: boolean;
}
