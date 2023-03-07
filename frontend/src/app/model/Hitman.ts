import {Rating} from "./Rating";
import {TypeOfExe} from "./TypeOfExe";
import {User} from "./User";
import {Auftrag} from "./Auftrag";
import {AreaOfOp} from "./AreaOfOp";

export interface Hitman {

TYPE_OF_EXECUTION: TypeOfExe;
torture: boolean;

areaOfOperation: AreaOfOp;

auftrag: Auftrag;

ratings: Rating[];
user: User;


}

