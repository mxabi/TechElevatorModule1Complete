package com.techelevator.farm;

import java.util.ArrayList;

//String is final, I cannot extend it
/*
public class NotAllowedToExtendString extends String {
}
*/
//we're allowed to extend ArrayList (this class is not public
//because public classes have to have the same file name as the class
class AllowedToExtendArrayList extends ArrayList {

}
