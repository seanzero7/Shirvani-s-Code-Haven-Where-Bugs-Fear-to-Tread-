import com.entities.Character;
import com.entities.Item;
import com.entities.Place;
import com.playerInput.ActionChoice;
import com.playerInput.PositionChoice;
import com.playerInput.PositionChoice.Condition;
import com.playerInput.SelectionChoice;
import com.sequences.CharacterCreation;
import com.entities.*;
import com.storygraph.ActionMap;
import com.storygraph.INode;
import com.storygraph.Node;
import java.util.HashMap;

import com.actions.*;

public class ShortStory implements IStory{
	
	public enum NodeLabels{
		CastleBedroom, IgnorePrincess, PickUpBlueBook, KneelandGivePrincessBlueBook, ExitCastleBedroom,CampArrived, ShowSoldierSkills, GiveChildCompass, ClapChild, SoldierAttack,GameOverRun, SoldierDialog, WalkToCampExit, WarlockDialog,GameOverDieRuins, WalkToCastleBedroomDoor,AlchemyShopNode,SellBookForCoins,WalkToBandit,TakeBanditsLoot,RevivePrincess,CityNode,BuySwordFromMerchant,BlackSmithAttack,SpookyPathNode,BanditSpookyPath,GameOverCity, GameOverDieSpookyPath,
		Init, Start, TalkToPrincess, ExitHome,BlacksmithScene,ExitBlackSmith,BridgeScene,ExitBridge,AlchemyShopScene,TalkToPrincess2,PrincessExit,DungeonChest,DungeonTable,RuinsSorcerer,ReviveAfterRuins,CourtYard,ReviveAfterCourtyard,BlacksmithScene2,DungeonWakeUp,PostDungeonWakeUp1,PostDungeonWakeUp2
		
	}
	public enum ChoiceLabels {
		Accept, Reject, WalkToTable, WalkToCastleBedroomDoor, LeaveCastleBedroom, TalkToChild, TalkToSoldier, AttackDummy ,DanceWithChild,AttackChild, GiveSoldierHelm,AttackSoldier, ArriveRuins, WarlockAttack, Run, LookAtBlueBook, PocketBlueBook, ArriveAlchemyShop,UnpocketBlueBook,AttackBandit,LeaveRuins, PrincessDie, ArriveCity, WalkToMerchant, PocketSword,AttackMerchant,WalkToDirtPile, BanditAttack, WalkToBlueHouseDoorCity
	}
	public enum Cnames {
		Sean, Princess, Soldier, Child, Warlock, Bandit, Merchant, Blacksmith, Alchemist, Troll, Blacksmither, Prisoner, Sorcerer, Knight, PrisonGuard
	}
	public enum Inames {
		Compass, BlueBook, Sword, Coin, Helmet, PurplePotion, GreenBook, Key
	}
	public enum Pnames {
		CastleBedroom, Camp, Ruins, AlchemyShop, SpookyPath,City, Dungeon, BlackSmith, Home, Bridge, Courtyard
	}
	HashMap<Cnames, Character> clist = new HashMap<>();
	HashMap<Inames, Item> ilist = new HashMap<>();
	HashMap<Pnames, Place> plist = new HashMap<>();
	
	public ShortStory() {
		getThings();
	}
	@Override 
	public void getThings() {
		clist.put(Cnames.Sean, new Character(Cnames.Sean.toString(), Character.BodyType.D , Character.Clothing.Beggar));
		clist.put(Cnames.Princess, new Character(Cnames.Princess.toString(), Character.BodyType.C , Character.Clothing.Queen));
		clist.put(Cnames.Soldier, new Character(Cnames.Soldier.toString(), Character.BodyType.D , Character.Clothing.LightArmour));
		clist.put(Cnames.Child, new Character(Cnames.Child.toString(), Character.BodyType.D , Character.Clothing.Peasant));
		clist.put(Cnames.Warlock, new Character(Cnames.Warlock.toString(), Character.BodyType.H , Character.Clothing.HeavyArmour));
		clist.put(Cnames.Merchant, new Character(Cnames.Merchant.toString(), Character.BodyType.H , Character.Clothing.Noble));
		clist.put(Cnames.Blacksmith, new Character(Cnames.Blacksmith.toString(), Character.BodyType.H , Character.Clothing.LightArmour));
		clist.put(Cnames.Bandit, new Character(Cnames.Bandit.toString(), Character.BodyType.F, Character.Clothing.Bandit));
		clist.put(Cnames.Alchemist, new Character(Cnames.Alchemist.toString(), Character.BodyType.H, Character.Clothing.Noble));
		ilist.put(Inames.Compass, new Item(Inames.Compass.toString(),Item.Items.Compass));
		ilist.put(Inames.BlueBook, new Item(Inames.BlueBook.toString(),Item.Items.BlueBook));
		ilist.put(Inames.Sword, new Item(Inames.Sword.toString(),Item.Items.Sword));
		ilist.put(Inames.Coin, new Item(Inames.Coin.toString(),Item.Items.Coin));
		ilist.put(Inames.Helmet, new Item(Inames.Helmet.toString(),Item.Items.Helmet));
		plist.put(Pnames.CastleBedroom, new Place(Pnames.CastleBedroom.toString(),Place.Places.CastleBedroom));
		plist.put(Pnames.Camp, new Place(Pnames.Camp.toString(),Place.Places.Camp));
		plist.put(Pnames.Ruins, new Place(Pnames.Ruins.toString(),Place.Places.Ruins));
		plist.put(Pnames.AlchemyShop, new Place(Pnames.AlchemyShop.toString(),Place.Places.AlchemyShop));
		plist.put(Pnames.SpookyPath, new Place(Pnames.SpookyPath.toString(),Place.Places.SpookyPath));
		plist.put(Pnames.City, new Place(Pnames.City.toString(),Place.Places.City));

	}

	@Override
	public ActionMap getMap() {
		var map = new ActionMap();
		map.add(NodeLabels.Init.toString(), getInitSequence());
		map.add(NodeLabels.Start.toString(), getStartSequence());
		map.add(NodeLabels.TalkToPrincess.toString(), getTalkToPrincessSequence());
		map.add(NodeLabels.ExitHome.toString(), getExitHomeSequence());
		map.add(NodeLabels.BlacksmithScene.toString(), getBlacksmithSceneSequence());
		map.add(NodeLabels.ExitBlackSmith.toString(), getExitBlackSmithSequence());
		map.add(NodeLabels.BridgeScene.toString(), getBridgeSceneSequence());
		map.add(NodeLabels.ExitBridge.toString(), getExitBridgeSequence());
		map.add(NodeLabels.AlchemyShopScene.toString(), getAlchemyShopSceneSequence());
		map.add(NodeLabels.TalkToPrincess2.toString(), getTalkToPrincess2Sequence());
		map.add(NodeLabels.PrincessExit.toString(), getPrincessExitSequence());
		map.add(NodeLabels.DungeonChest.toString(), getDungeonChestSequence());
		map.add(NodeLabels.DungeonTable.toString(), getDungeonTableSequence());
		map.add(NodeLabels.RuinsSorcerer.toString(), getRuinsSorcererSequence());
		map.add(NodeLabels.ReviveAfterRuins.toString(), getReviveAfterRuinsSequence());
		map.add(NodeLabels.CourtYard.toString(), getCourtYardSequence());
		map.add(NodeLabels.ReviveAfterCourtyard.toString(), getReviveAfterCourtyardSequence());
		map.add(NodeLabels.BlacksmithScene2.toString(), getBlacksmithScene2Sequence());
		map.add(NodeLabels.DungeonWakeUp.toString(), getDungeonWakeUpSequence());
		map.add(NodeLabels.PostDungeonWakeUp1.toString(), getPostDungeonWakeUp1Sequence());
		map.add(NodeLabels.PostDungeonWakeUp2.toString(), getPostDungeonWakeUp2Sequence());
		map.add(NodeLabels.CastleBedroom.toString(), getCastleBedroom());
		map.add(NodeLabels.IgnorePrincess.toString(), getIgnorePrincess());
		map.add(NodeLabels.PickUpBlueBook.toString(), getPickUpBlueBook());
		map.add(NodeLabels.KneelandGivePrincessBlueBook.toString(), getKneelandGivePrincessBlueBook());
		map.add(NodeLabels.ExitCastleBedroom.toString(), getExitCastleBedroom());
		map.add(NodeLabels.CampArrived.toString(), getCampArrived());
		map.add(NodeLabels.ShowSoldierSkills.toString(), getShowSoldierSkills());
		map.add(NodeLabels.GiveChildCompass.toString(), getGiveChildCompass());
		map.add(NodeLabels.SoldierDialog.toString(), getSoldierDialog());
		map.add(NodeLabels.ClapChild.toString(), getClapChild());
		map.add(NodeLabels.SoldierAttack.toString(), getSoldierAttack());
		map.add(NodeLabels.WalkToCampExit.toString(), getWalkToCampExit());
		map.add(NodeLabels.GameOverRun.toString(), getGameOverRun());
		map.add(NodeLabels.WarlockDialog.toString(), getWarlockDialog());
		map.add(NodeLabels.GameOverDieRuins.toString(), getGameOverDieRuins());
		map.add(NodeLabels.WalkToCastleBedroomDoor.toString(), getWalkToCastleBedroomDoor());
		map.add(NodeLabels.AlchemyShopNode.toString(), getAlchemyShopNode());
		map.add(NodeLabels.SellBookForCoins.toString(), getSellBookForCoins());
		map.add(NodeLabels.WalkToBandit.toString(), getWalkToBandit());
		map.add(NodeLabels.TakeBanditsLoot.toString(), getTakeBanditsLoot());
		map.add(NodeLabels.RevivePrincess.toString(), getRevivePrincess());
		map.add(NodeLabels.CityNode.toString(), getCityNode());
		map.add(NodeLabels.BuySwordFromMerchant.toString(), getBuySwordFromMerchant());
		map.add(NodeLabels.BlackSmithAttack.toString(), getBlackSmithAttack());
		map.add(NodeLabels.GameOverCity.toString(), getGameOverCity());
		map.add(NodeLabels.SpookyPathNode.toString(), getSpookyPathNode());
		map.add(NodeLabels.BanditSpookyPath.toString(), getBanditSpookyPath());
		map.add(NodeLabels.GameOverDieSpookyPath.toString(), getGameOverDieSpookyPath());
		return map;
	}
	
	
	private ActionSequence getInitSequence() {
		var Sean = clist.get(Cnames.Sean);
		var Home = plist.get(Pnames.Home);
		var sequence = new ActionSequence();
		sequence.add(new EnableInput(false));
		sequence.combineWith(new CharacterCreation(Sean));
		sequence.add(new SetPosition(Sean, Home));
		sequence.add(new SetCameraFocus(Sean));
		sequence.add(new ShowMenu(true));
		sequence.add(new Wait(5));
		return sequence;
		}
		private ActionSequence getStartSequence() {
		var sequence=new ActionSequence();
		sequence.add(new ShowMenu(false));
		sequence.add(new EnableInput(true));
		return sequence;
		}
		private ActionSequence getTalkToPrincessSequence() {
		var Princess = clist.get(Cnames.Princess);
		var Coin = ilist.get(Inames.Coin);
		var Sean = clist.get(Cnames.Sean);
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(Princess));
		sequence.add(new Create<Item>(Coin));
		sequence.add(new SetPosition(Coin,Princess));
		sequence.add(new WalkTo(Sean, Princess));
		sequence.add(new Wait(5));
		sequence.add(new SetDialog("Dance for me, you get a coin unto thee [Dance|I'll dance for money. Need me a sugar Momma] [Steal|Do I look like your damn jester?]"));
		sequence.add(new ShowDialog());
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		sequence.add(new Dance(Sean));
		sequence.add(new Give(Princess,Coin,Sean));
		return sequence;
		}

		private ActionSequence getExitHomeSequence() {
		var Sean = clist.get(Cnames.Sean);
		var Home = plist.get(Pnames.Home);

		var sequence = new ActionSequence();
		sequence.add(new Exit(Sean, Home.getFurniture("Door"), true));
		return sequence;
		}
		private ActionSequence getBlacksmithSceneSequence() {
		var Blacksmither = clist.get(Cnames.Blacksmither);
		var Coin = ilist.get(Inames.Coin);
		var BlackSmith = plist.get(Pnames.BlackSmith);
		var Sean = clist.get(Cnames.Sean);
		var Sword = ilist.get(Inames.Sword);
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(Blacksmither));
		sequence.add(new Create<Place>(BlackSmith));
		sequence.add(new SetPosition(Sean, BlackSmith));
		sequence.add(new WalkTo(Sean, Blacksmither));
		sequence.add(new SetDialog("Are you sure you want to buy that sword? It's gonna cost you [Buy|I know what I'm about son] [Steal|Nah, i'd rather just take it from you]"));
		sequence.add(new ShowDialog());
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		sequence.add(new Give(Sean,Coin,Blacksmither));
		sequence.add(new Create<Item>(Sword));
		sequence.add(new Give(Blacksmither,Sword,Sean));
		return sequence;
		}
		private ActionSequence getExitBlackSmithSequence() {
		var BlackSmith = plist.get(Pnames.BlackSmith);
		var Sean = clist.get(Cnames.Sean);

		var sequence = new ActionSequence();
		sequence.add(new Exit(Sean, BlackSmith.getFurniture("Door"), true));
		return sequence;
		}
		private ActionSequence getBridgeSceneSequence() {
		var Troll = clist.get(Cnames.Troll);
		var Bridge = plist.get(Pnames.Bridge);
		var Potion = ilist.get(Inames.PurplePotion);
		var Compass = ilist.get(Inames.Compass);
		var Book = ilist.get(Inames.GreenBook);
		var Helmet = ilist.get(Inames.Helmet);
		var Sean = clist.get(Cnames.Sean);
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(Troll));
		sequence.add(new Create<Place>(Bridge));
		sequence.add(new SetPosition(Sean, Bridge));
		sequence.add(new SetCameraFocus(Sean));
		sequence.add(new SetDialog("Somehow you are even uglier than me! Lets see if you fight as badly as you look [Fight!|You're on!]"));
		sequence.add(new Attack(Sean,Troll,true));
		sequence.add(new Wait(5));
		sequence.add(new Create<Item>(Potion));
		sequence.add(new SetPosition(Potion, Bridge));
		sequence.add(new Take(Sean,Potion));
		sequence.add(new Pocket(Sean,Potion));
		sequence.add(new Create<Item>(Compass));
		sequence.add(new SetPosition(Compass, Bridge));
		sequence.add(new Take(Sean,Compass));
		sequence.add(new Pocket(Sean,Compass));
		sequence.add(new Create<Item>(Book));
		sequence.add(new SetPosition(Book, Bridge));
		sequence.add(new Take(Sean,Book));
		sequence.add(new Pocket(Sean,Book));
		sequence.add(new Create<Item>(Helmet));
		sequence.add(new SetPosition(Helmet, Bridge));
		sequence.add(new Take(Sean,Helmet));
		sequence.add(new Pocket(Sean,Helmet));
		return sequence;
		}
		private ActionSequence getExitBridgeSequence() {
		var sequence = new ActionSequence();
		var Sean = clist.get(Cnames.Sean);
		var Bridge = plist.get(Pnames.Bridge);

		sequence.add(new Exit(Sean, Bridge.getFurniture("NorthEnd"), true));
		return sequence;
		}
		private ActionSequence getAlchemyShopSceneSequence() {
		var Alchemist = clist.get(Cnames.Alchemist);
		var AlchemyShop = plist.get(Pnames.AlchemyShop);
		var Sean = clist.get(Cnames.Sean);
		var Potion = ilist.get(Inames.PurplePotion);
		var Book = ilist.get(Inames.GreenBook);
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(Alchemist));
		sequence.add(new Create<Place>(AlchemyShop));
		sequence.add(new SetPosition(Sean, AlchemyShop));
		sequence.add(new WalkTo(Sean, Alchemist));
		sequence.add(new ShowDialog());
		sequence.add(new SetDialog("Do you have the book? [Yes|Yes, and the potion too.]"));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		sequence.add(new Unpocket(Sean, Book));
		sequence.add(new Give(Sean,Book,Alchemist));
		sequence.add(new Unpocket(Sean,Potion));
		sequence.add(new Give(Sean,Potion,Alchemist));
		return sequence;
		}
		private ActionSequence getTalkToPrincess2Sequence() {
		var Princess = clist.get(Cnames.Princess);
		var Coin = ilist.get(Inames.Coin);
		var Sean = clist.get(Cnames.Sean);
		var Potion = ilist.get(Inames.PurplePotion);
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(Princess));
		sequence.add(new Create<Item>(Coin));
		sequence.add(new SetPosition(Coin,Princess));
		sequence.add(new Create<Item>(Potion));
		sequence.add(new SetPosition(Potion,Princess));
		sequence.add(new WalkTo(Sean, Princess));
		sequence.add(new ShowDialog());
		sequence.add(new SetDialog("Dance for me, you get a coin unto thee [Dance|I'll dance for money. Need me a Sugar Momma] [Steal|Do I look like your damn jester?]"));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		sequence.add(new Take(Sean,Coin,Princess));
		sequence.add(new Give(Princess,Potion,Sean));
		sequence.add(new Drink(Sean));
		return sequence;
		}
		private ActionSequence getPrincessExitSequence() {
		var Sean = clist.get(Cnames.Sean);
		var Home = plist.get(Pnames.Home);

		var sequence = new ActionSequence();
		sequence.add(new Exit(Sean, Home.getFurniture("Fireplace"), true));
		return sequence;
		}
		private ActionSequence getDungeonChestSequence() {
		var Sean = clist.get(Cnames.Sean);
		var Dungeon = plist.get(Pnames.Dungeon);
		var Prisoner = clist.get(Cnames.Prisoner);
		var Key = ilist.get(Inames.Key);
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(Prisoner));
		sequence.add(new Create<Place>(Dungeon));
		sequence.add(new SetPosition(Prisoner,Dungeon));
		sequence.add(new WalkTo(Sean, Prisoner));
		sequence.add(new SetDialog("Choose carefully: Table or Chest. Hint: The Chest may be dangerous... [Table|Table it is!] [Chest|Chest it is!]"));
		sequence.add(new ShowDialog());
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		sequence.add(new WalkTo(Sean,Dungeon.getFurniture("Chest")));
		sequence.add(new OpenFurniture(Sean,Dungeon.getFurniture("Chest")));
		sequence.add(new Create<Item>(Key));
		sequence.add(new SetPosition(Key,Dungeon,"Chest"));
		sequence.add(new Take(Sean,Key));
		return sequence;
		}
		private ActionSequence getDungeonTableSequence() {
		var Sean = clist.get(Cnames.Sean);
		var Dungeon = plist.get(Pnames.Dungeon);
		var Prisoner = clist.get(Cnames.Prisoner);
		var Key = ilist.get(Inames.Key);
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(Prisoner));
		sequence.add(new Create<Place>(Dungeon));
		sequence.add(new SetPosition(Prisoner,Dungeon));
		sequence.add(new WalkTo(Sean, Prisoner));
		sequence.add(new ShowDialog());
		sequence.add(new SetDialog("Choose carefully: Table or Chest. Hint: The Chest may be dangerous... [Table|Table it is!] [Chest|Chest it is!]"));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		sequence.add(new WalkTo(Sean,Dungeon.getFurniture("Table")));
		sequence.add(new Create<Item>(Key));
		sequence.add(new SetPosition(Key,Dungeon,"Table"));
		sequence.add(new Take(Sean,Key));
		return sequence;
		}
		private ActionSequence getRuinsSorcererSequence() {
		var Sorcerer = clist.get(Cnames.Sorcerer);
		var Ruins = plist.get(Pnames.Ruins);
		var Sean = clist.get(Cnames.Sean);
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(Sorcerer));
		sequence.add(new Create<Place>(Ruins));
		sequence.add(new SetPosition(Sorcerer,Ruins));
		sequence.add(new WalkTo(Sean, Sorcerer));
		sequence.add(new SetDialog("These Ruins are mine! Get out! Get out! [Stay|Who said that these are YOUR ruins huh?]"));
		sequence.add(new ShowDialog());
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		sequence.add(new WalkTo(Sorcerer,Sean));
		sequence.add(new Die(Sean));
		return sequence;
		}
		private ActionSequence getReviveAfterRuinsSequence() {
		var Alchemist = clist.get(Cnames.Alchemist);
		var AlchemyShop = plist.get(Pnames.AlchemyShop);
		var Sean = clist.get(Cnames.Sean);
		var Coin = ilist.get(Inames.Coin);
		var sequence = new ActionSequence();
		sequence.add(new SetPosition(Sean,AlchemyShop));
		sequence.add(new WalkTo(Sean, Alchemist));
		sequence.add(new ShowDialog());
		sequence.add(new SetDialog("Wow you took quite the hit. Good Thing I was able to revive you. Here's a coin for your trouble. [Thank you!|Yeah I got my sh!t wrecked by that freak]"));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		sequence.add(new Give(Alchemist,Coin,Sean));
		return sequence;
		}
		private ActionSequence getCourtYardSequence() {
		var Knight = clist.get(Cnames.Knight);
		var Courtyard = plist.get(Pnames.Courtyard);
		var Sean = clist.get(Cnames.Sean);
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(Knight));
		sequence.add(new Create<Place>(Courtyard));
		sequence.add(new SetPosition(Sean,Courtyard));
		sequence.add(new WalkTo(Knight, Sean));
		sequence.add(new ShowDialog());
		sequence.add(new SetDialog("Where did you get that key? [Chest|I got it from the chest in the Ruins!]"));
		sequence.add(new ShowDialog());
		sequence.add(new Wait(5));
		sequence.add(new SetDialog("The forbidden Key!! But you are just a mortal. You must die now"));
		sequence.add(new ShowDialog());
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		sequence.add(new Attack(Knight,Sean,true));
		sequence.add(new Wait(5));
		sequence.add(new Die(Sean));
		return sequence;
		}
		private ActionSequence getReviveAfterCourtyardSequence() {
		var Blacksmither = clist.get(Cnames.Blacksmither);
		var BlackSmith = plist.get(Pnames.BlackSmith);
		var Sean = clist.get(Cnames.Sean);
		var sequence = new ActionSequence();
		sequence.add(new SetPosition(Sean,BlackSmith));
		sequence.add(new WalkTo(Sean, Blacksmither));
		sequence.add(new SetDialog("Hey, you're awake. Good Thing I was able to revive you. Sounds like you need some real armor. [Yes Please!|Yeah I got my sh!t wrecked by that freak]"));
		sequence.add(new ShowDialog());
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		return sequence;
		}
		private ActionSequence getBlacksmithScene2Sequence() {
		var Blacksmither = clist.get(Cnames.Blacksmither);
		var BlackSmith = plist.get(Pnames.BlackSmith);
		var Sean = clist.get(Cnames.Sean);
		var Sword = ilist.get(Inames.Sword);
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(Blacksmither));
		sequence.add(new Create<Place>(BlackSmith));
		sequence.add(new SetPosition(Sean, BlackSmith));
		sequence.add(new WalkTo(Sean, Blacksmither));
		sequence.add(new SetDialog("Are you sure you want to buy that sword? It's gonna cost you [Buy|I know what I'm about son] [Steal|Nah, i'd rather just take it from you]"));
		sequence.add(new ShowDialog());
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		sequence.add(new Take(Sean,Sword,Blacksmither));
		return sequence;
		}
		private ActionSequence getDungeonWakeUpSequence() {
		var PrisonGuard = clist.get(Cnames.PrisonGuard);
		var Dungeon = plist.get(Pnames.Dungeon);
		var Sean = clist.get(Cnames.Sean);
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(PrisonGuard));
		sequence.add(new Create<Place>(Dungeon));
		sequence.add(new SetPosition(Sean, Dungeon));
		sequence.add(new WalkTo(Sean, PrisonGuard));
		sequence.add(new SetDialog("They call me the politician. Bribe me and I'll let you free. [Give Coin|Get me the heck outta here] [Get your own money!|Get your own money!]"));
		sequence.add(new ShowDialog());
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		sequence.add(new Exit(Sean, Dungeon.getFurniture("Door"), true));
		return sequence;
		}
		private ActionSequence getPostDungeonWakeUp1Sequence() {
		var Dungeon = plist.get(Pnames.Dungeon);
		var Sean = clist.get(Cnames.Sean);
		var sequence = new ActionSequence();
		sequence.add(new Create<Place>(Dungeon));
		sequence.add(new SetPosition(Sean, Dungeon));
		sequence.add(new ShowDialog());
		sequence.add(new SetDialog("Let me goooo! I'm sorry!!!!! [You Lose|You Lose]"));
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		return sequence;
		}
		private ActionSequence getPostDungeonWakeUp2Sequence() {
		var City = plist.get(Pnames.City);
		var Sean = clist.get(Cnames.Sean);
		var sequence = new ActionSequence();
		sequence.add(new Create<Place>(City));
		sequence.add(new SetPosition(Sean, City));
		sequence.add(new SetDialog("Congratulations. You won. [Nice!|Thanks for playing!]"));
		sequence.add(new ShowDialog());
		sequence.add(new Wait(5));
		sequence.add(new HideDialog());
		return sequence;
		}
	
	private ActionSequence getCastleBedroom() {
		var Sean = clist.get(Cnames.Sean);
		var Princess = clist.get(Cnames.Princess);
		var Compass = ilist.get(Inames.Compass);
		var Sword = ilist.get(Inames.Sword);
		var CastleBedroom = plist.get(Pnames.CastleBedroom);
		var sq = new ActionSequence();
		sq.add(new Create<Character>(Sean));
		sq.add(new SetClothing(Sean));
		sq.add(new Create<Character>(Princess));
		sq.add(new SetClothing(Princess));
		sq.add(new Create<Place>(CastleBedroom));
		sq.add(new Create<Item>(Compass));
		sq.add(new Create<Item>(Sword));
		sq.add(new Position(Sean,CastleBedroom,"Fireplace"));
		sq.add(new Position(Princess,CastleBedroom,"Couch"));
		sq.add(new Pocket(Sean,Compass));
		sq.add(new Pocket(Sean,Sword));
		sq.add(new SetCameraFocus(Princess));
		sq.add(new Face(Sean,Princess));
		sq.add(new ShowMenu(true));
		sq.add(new ShowMenu(false));
		sq.add(new EnableInput(true));
		return sq;
	}
	
	private ActionSequence getIgnorePrincess() {
		var Sean = clist.get(Cnames.Sean);
		var CastleBedroom = plist.get(Pnames.CastleBedroom);
		var Princess = clist.get(Cnames.Princess);
		var sq = new ActionSequence();
		sq.add(new Face(Sean,CastleBedroom.getFurniture("Door")));
		sq.add(new SetCameraFocus(Sean));
		return sq;
	}
	private ActionSequence getPickUpBlueBook() {
		var sq = new ActionSequence();
		var Sean = clist.get(Cnames.Sean);
		var BlueBook = ilist.get(Inames.BlueBook);
		var Princess = clist.get(Cnames.Princess);
		var CastleBedroom = plist.get(Pnames.CastleBedroom);
		sq.add(new Create<Item>(BlueBook));
		sq.add(new SetCameraFocus(BlueBook));
		sq.add(new Take(Sean,BlueBook,CastleBedroom.getFurniture("Table.Left")));
		return sq;
	}
	
	private ActionSequence getKneelandGivePrincessBlueBook() {
		var sq = new ActionSequence();
		var Sean = clist.get(Cnames.Sean);
		var BlueBook = ilist.get(Inames.BlueBook);
		var Princess = clist.get(Cnames.Princess);
		var CastleBedroom = plist.get(Pnames.CastleBedroom);
		sq.add(new WalkTo(Sean,Princess));
		sq.add(new SetCameraFocus(Princess));
		sq.add(new Face(Sean,Princess));
		sq.add(new Kneel(Sean));
		sq.add(new Give(Sean,BlueBook,Princess));
		sq.add(new SetRight(Sean));
		sq.add(new SetDialog("Here you are my lady"));
		sq.add(new ShowDialog());
		return sq;
	}
	
	private ActionSequence getExitCastleBedroom() {
		var sq = new ActionSequence();
		var CastleBedroom = plist.get(Pnames.CastleBedroom);
		var Sean = clist.get(Cnames.Sean);
		sq.add(new SetCameraFocus(Sean));
		sq.add(new Exit(Sean,CastleBedroom.getFurniture("Door"), true));
		return sq;
	}
	
	private ActionSequence getCampArrived() {
		var sq = new ActionSequence();
		var Sean = clist.get(Cnames.Sean);
		var Soldier = clist.get(Cnames.Soldier);
		var Child = clist.get(Cnames.Child);
		var Camp = plist.get(Pnames.Camp);
		var Sword = ilist.get(Inames.Sword);
		sq.add(new Create<Character>(Child));
		sq.add(new SetClothing(Child));
		sq.add(new Create<Character>(Soldier));
		sq.add(new SetClothing(Soldier));
		sq.add(new Create<Item>(Sword));
		sq.add(new Create<Place>(Camp));
		sq.add(new SetCameraFocus(Sean));
		sq.add(new Position(Sean, Camp,"cauldron"));
		sq.add(new Position(Child,Camp,"leftlog"));
		sq.add(new Position(Soldier,Camp,"rightlog"));
		return sq;
	}
	
	private ActionSequence getShowSoldierSkills() {
		var sq = new ActionSequence();
		var Sean = clist.get(Cnames.Sean);
		var Soldier = clist.get(Cnames.Soldier);
		var Child = clist.get(Cnames.Child);
		var Compass = ilist.get(Inames.Compass);
		var Sword = ilist.get(Inames.Sword);
		var Camp = plist.get(Pnames.Camp);
		sq.add(new SetCameraFocus(Sean));
		sq.add(new WalkTo(Sean,Soldier));
		sq.add(new Face(Sean,Soldier));
		sq.add(new SetLeft(Soldier));
		sq.add(new SetRight(Sean));
		sq.add(new SetDialog("|How are you fine sir,I would like to train"));
		sq.add(SetDialog("Let me see what you got"));
		sq.add(new ShowDialog());
		sq.add(new Draw(Sean,Sword));
		return sq;
	}
	
	
	private IAction SetDialog(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	private ActionSequence getGiveChildCompass() {
		var sq = new ActionSequence();
		var Sean = clist.get(Cnames.Sean);
		var Soldier = clist.get(Cnames.Soldier);
		var Child = clist.get(Cnames.Child);
		var Compass = ilist.get(Inames.Compass);
		var Camp = plist.get(Pnames.Camp);
		sq.add(new SetCameraFocus(Sean));
		sq.add(new WalkTo(Sean,Child));
		sq.add(new Face(Sean,Child));
		sq.add(new SetLeft(Child));
		sq.add(new SetDialog("Hello young boy, here is a gift for you"));
		sq.add(new ShowDialog());
		sq.add(new Draw(Sean,Compass));
		sq.add(new Give(Sean,Compass,Child));
		sq.add(new SetDialog("ThankYou"));
		sq.add(new ShowDialog());
		return sq;
	}
	
	private ActionSequence getSoldierDialog() {
		var sq = new ActionSequence();
		var Sean = clist.get(Cnames.Sean);
		var Soldier = clist.get(Cnames.Soldier);
		var Sword = ilist.get(Inames.Sword);
		sq.add(new SetCameraFocus(Sean));
		sq.add(new SetLeft(Soldier));
		sq.add(new Face(Sean,Soldier));
		sq.add(new SetDialog("You are a skilled swordsman|"));
		sq.add(new ShowDialog());
		return sq;
	}
	
	private ActionSequence getClapChild () {
		var sq = new ActionSequence();
		var Sean = clist.get(Cnames.Sean);
		var Child = clist.get(Cnames.Child);
		var Compass = ilist.get(Inames.Compass);
		var Sword = ilist.get(Inames.Sword);
		var Camp = plist.get(Pnames.Camp);
		sq.add(new SetCameraFocus(Child));
		sq.add(new Clap(Child));
		sq.add(new Face(Sean,Child));
		sq.add(new Draw(Sean,Sword));
		return sq;
	}
	private ActionSequence getSoldierAttack() {
		var sq = new ActionSequence();
		var Sean = clist.get(Cnames.Sean);
		var Child = clist.get(Cnames.Child);
		var Soldier = clist.get(Cnames.Soldier);
		var Sword = ilist.get(Inames.Sword);
		var Camp = plist.get(Pnames.Camp);
		sq.add(new SetCameraFocus(Sean));
		sq.add(new WalkTo(Soldier,Sean));
		sq.add(new Face(Soldier,Sean));
		sq.add(new Draw(Soldier,Sword));
		sq.add(new SetLeft(Soldier));
		sq.add(new SetDialog("What do you think you're doing!?"));
		sq.add(new Attack(Soldier,Sean));
		sq.add(new ShowDialog());
		return sq;
	}
	
	private ActionSequence getWalkToCampExit() {
		var sq = new ActionSequence();
		var Soldier = clist.get(Cnames.Soldier);
		var Sean = clist.get(Cnames.Sean);
		var Sword = ilist.get(Inames.Sword);
		var Helmet = ilist.get(Inames.Helmet);
		var Camp = plist.get(Pnames.Camp);
		sq.add(new WalkTo(Sean,Camp.getFurniture("Exit")));
		sq.add(new Exit(Sean,Camp.getFurniture("Exit"),true));
		return sq;
	}
	
	private ActionSequence getGameOverRun() {
		var sq = new ActionSequence();
		var Soldier = clist.get(Cnames.Soldier);
		var Sean = clist.get(Cnames.Sean);
		var Sword = ilist.get(Inames.Sword);
		var Camp = plist.get(Pnames.Camp);
		sq.add(new HideDialog());
		sq.add(new WalkTo(Sean,Camp.getFurniture("Exit")));
		sq.add(new SetNarration("Sean ran away from the camp and a bounty of 5,000 gold coins was placed on his head. He left the kingdom forever"));
		sq.add(new ShowNarration());
		return sq;
	}
	
	private ActionSequence getWarlockDialog() {
		var sq = new ActionSequence();
		var Sean = clist.get(Cnames.Sean);
		var Sword = ilist.get(Inames.Sword);
		var Helmet = ilist.get(Inames.Helmet);
		var Ruins = plist.get(Pnames.Ruins);
		var Warlock = clist.get(Cnames.Warlock);
		sq.add(new Create<Character>(Warlock));
		sq.add(new SetClothing(Warlock));
		sq.add(new Create<Place>(Ruins));
		sq.add(new SetCameraFocus(Sean));
		sq.add(new Position(Sean,Ruins,"altar")); 
		sq.add(new Position(Warlock,Ruins,"chest"));
		sq.add(new WalkTo(Warlock,Sean));
		sq.add(new Face(Warlock,Sean));
		sq.add(new SetLeft(Warlock));
		sq.add(new SetRight(Sean));
		sq.add(new SetDialog("What are you doing in my territory"));
		sq.add(new SetDialog("I stumbled here by mistake"));
		sq.add(new ShowDialog());
		sq.add(new Draw(Sean,Sword));

		return sq;
	}
	
	private ActionSequence getGameOverDieRuins() {
		var sq = new ActionSequence();
		var Sean = clist.get(Cnames.Sean);
		var Sword = ilist.get(Inames.Sword);
		var Helmet = ilist.get(Inames.Helmet);
		var Ruins = plist.get(Pnames.Ruins);
		var Warlock = clist.get(Cnames.Warlock);
		sq.add(new HideDialog());
		sq.add(new SetNarration("The Warlock was too strong and demolished you instantly. You died"));
		sq.add(new ShowNarration());
		return sq;
	}
	
	private ActionSequence getWalkToCastleBedroomDoor() {
		var sq = new ActionSequence();
		var Sean = clist.get(Cnames.Sean);
		var BlueBook = ilist.get(Inames.BlueBook);
		var Princess = clist.get(Cnames.Princess);
		var CastleBedroom = plist.get(Pnames.CastleBedroom);
		sq.add(new SetCameraFocus(Sean));
		sq.add(new Face(Sean,CastleBedroom.getFurniture("Door")));
		sq.add(new WalkTo(Sean,CastleBedroom.getFurniture("Door")));
		sq.add(new Exit(Sean,CastleBedroom.getFurniture("Door"),true));
		return sq;
	}
	
	private ActionSequence getAlchemyShopNode() {
		var sq = new ActionSequence();
		var Sean = clist.get(Cnames.Sean);
		var AlchemyShop = plist.get(Pnames.AlchemyShop);
		var BlueBook = ilist.get(Inames.BlueBook);
		var Alchemist = clist.get(Cnames.Alchemist);
		sq.add(new Create<Character>(Alchemist));
		sq.add(new SetClothing(Alchemist));
		sq.add(new Create<Place>(AlchemyShop));
		sq.add(new Position(Sean,AlchemyShop,"door"));
		sq.add(new Position(Alchemist,AlchemyShop,"Bar"));
		sq.add(new SetCameraFocus(Sean));
		sq.add(new Face(Sean,Alchemist));
		sq.add(new WalkTo(Sean,Alchemist));
		return sq;
	}
	
	private ActionSequence getSellBookForCoins() {
		var sq = new ActionSequence();
		var Sean = clist.get(Cnames.Sean);
		var AlchemyShop = plist.get(Pnames.AlchemyShop);
		var BlueBook = ilist.get(Inames.BlueBook);
		var Coin = ilist.get(Inames.Coin);
		var Alchemist = clist.get(Cnames.Alchemist);
		sq.add(new Create<Item>(Coin));
		sq.add(new SetLeft(Alchemist));
		sq.add(new SetRight(Sean));
		sq.add(new SetDialog("I would be willing to give you 50 coins for it|How many coins would you give up for this blue book?"));
		sq.add(new SetDialog("I like that price, I'll sell it!"));
		sq.add(new ShowDialog());
		sq.add(new Give(Sean,BlueBook,Alchemist));
		sq.add(new Give(Alchemist,Coin,Sean));
		sq.add(new Face(Sean,AlchemyShop.getFurniture("Bar")));
		sq.add(new WalkTo(Sean,AlchemyShop.getFurniture("door")));
		return sq;
	}
	
	private ActionSequence getWalkToBandit() {
		var sq = new ActionSequence();
		var Sean = clist.get(Cnames.Sean);
		var Bandit = clist.get(Cnames.Bandit);
		var Coin = ilist.get(Inames.Coin);
		var Ruins = plist.get(Pnames.Ruins);
		sq.add(new Create<Character>(Bandit));
		sq.add(new SetClothing(Bandit));
		sq.add(new Create<Place>(Ruins));
		sq.add(new Position(Sean,Ruins,"Exit"));
		sq.add(new Position(Bandit,Ruins,"plant"));
		sq.add(new SetCameraFocus(Sean));
		sq.add(new Face(Sean,Bandit));
		sq.add(new WalkTo(Sean,Bandit));
		sq.add(new HideDialog());
		sq.add(new SetRight(Sean));
		sq.add(new SetLeft(Bandit));
		sq.add(new SetDialog("We will see about that|Your reign of terror is no more"));
		sq.add(new ShowDialog());
		return sq;
	}
	
	private ActionSequence getTakeBanditsLoot() {
		var sq = new ActionSequence();
		var Sean = clist.get(Cnames.Sean);
		var Bandit = clist.get(Cnames.Bandit);
		var Ruins = plist.get(Pnames.Ruins);
		var Sword = ilist.get(Inames.Sword);
		sq.add(new Create<Item>(Sword));
		sq.add(new SetCameraFocus(Sean));
		sq.add(new Take(Sean,Sword));
		sq.add(new Pocket(Sean,Sword));
		sq.add(new WalkTo(Sean,Ruins.getFurniture("Exit")));
		return sq;
	}
	
	private ActionSequence getRevivePrincess() {
		var sq = new ActionSequence();
		var Sean = clist.get(Cnames.Sean);
		var Princess = clist.get(Cnames.Princess);
		var CastleBedroom = plist.get(Pnames.CastleBedroom);
		var Coin = ilist.get(Inames.Coin);
		sq.add(new Create<Item>(Coin));
		sq.add(new SetCameraFocus(Princess));
		sq.add(new Revive(Princess));
		sq.add(new SetLeft(Princess));
		sq.add(new SetRight(Sean)); 
		sq.add(new SetDialog("Oh my gosh, you saved me, you need a coin for this!|Ok ThankYou!"));
		sq.add(new ShowDialog());
		sq.add(new Give(Princess,Coin,Sean));
		sq.add(new Pocket(Sean,Coin));
		sq.add(new Face(Sean,CastleBedroom.getFurniture("door")));
		sq.add(new WalkTo(Sean,CastleBedroom.getFurniture("door")));
		sq.add(new Exit(Sean,CastleBedroom.getFurniture("door"),true));
		return sq;
	}
	
	private ActionSequence getCityNode() {
		var sq = new ActionSequence();
		var Sean = clist.get(Cnames.Sean);
		var Merchant = clist.get(Cnames.Merchant);
		var Coin = ilist.get(Inames.Coin);
		var City = plist.get(Pnames.City);
		sq.add(new SetCameraFocus(Sean));
		sq.add(new Position(Sean,City,"city"));
		sq.add(new Create<Character>(Merchant));
		sq.add(new Create<Place>(City));
		sq.add(new Position(Merchant,City));
		sq.add(new Face(Sean,Merchant));
		sq.add(new HideDialog());

		return sq;
	}
	
	private ActionSequence getBuySwordFromMerchant() {
		var sq = new ActionSequence();
		var Sean = clist.get(Cnames.Sean);
		var Merchant = clist.get(Cnames.Merchant);
		var Coin = ilist.get(Inames.Coin);
		var City = plist.get(Pnames.City);
		var Sword = ilist.get(Inames.Sword);
		sq.add(new Create<Item>(Sword));
		sq.add(new SetLeft(Merchant));
		sq.add(new SetRight(Sean));
		sq.add(new SetDialog("Yes it is!|Is this coin enough to purchase a sword?"));
		sq.add(new Give(Sean,Coin,Merchant));
		sq.add(new Give(Merchant,Sword,Sean));
		sq.add(new ShowDialog());
		return sq;
	}
	
	private ActionSequence getBlackSmithAttack() {
		var sq = new ActionSequence();
		var Sean = clist.get(Cnames.Sean);
		var Merchant = clist.get(Cnames.Merchant);
		var Coin = ilist.get(Inames.Coin);
		var City = plist.get(Pnames.City);
		var Sword = ilist.get(Inames.Sword);
		var Blacksmith = clist.get(Cnames.Blacksmith);
		sq.add(new Create<Character>(Blacksmith));
		sq.add(new SetCameraFocus(Blacksmith));
		sq.add(new SetLeft(Blacksmith));
		sq.add(new Face(Blacksmith,Sean));
		sq.add(new Draw(Blacksmith,Sword));
		sq.add(new WalkTo(Blacksmith,Sean));
		sq.add(new Attack(Blacksmith,Sean));
		sq.add(new SetDialog("What do you think you're doing!|"));
		sq.add(new ShowDialog());
		return sq;
	}
	
	private ActionSequence getGameOverCity() {
		var sq = new ActionSequence();
		var Sean = clist.get(Cnames.Sean);
		var Coin = ilist.get(Inames.Coin);
		var City = plist.get(Pnames.City);
		var Sword = ilist.get(Inames.Sword);
		sq.add(new SetCameraFocus(Sean));
		sq.add(new HideDialog());
		sq.add(new Exit(Sean,City.getFurniture("EastEnd"),true));
		sq.add(new SetNarration("Sean left the city immediately as a bounty of 10,000 gold coins was placed on his head for attacking the local Merchant"));
		sq.add(new ShowNarration());
		return sq;
	}
	
	private ActionSequence getSpookyPathNode() {
		var sq = new ActionSequence();
		var Sean = clist.get(Cnames.Sean);
		var SpookyPath = plist.get(Pnames.SpookyPath);
		var Sword = ilist.get(Inames.Sword);
		sq.add(new Create<Place>(SpookyPath));
		sq.add(new HideDialog());
		sq.add(new SetCameraFocus(Sean));
		sq.add(new Enter(Sean,SpookyPath,true));
		sq.add(new Position(Sean,SpookyPath));

		return sq;
	}
	
	private ActionSequence getBanditSpookyPath() {
		var sq = new ActionSequence();
		var Sean = clist.get(Cnames.Sean);
		var Bandit = clist.get(Cnames.Bandit);
		var Sword = ilist.get(Inames.Sword);
		var SpookyPath = plist.get(Pnames.SpookyPath);
		sq.add(new Create<Character>(Bandit));
		sq.add(new Face(Bandit,Sean));
		sq.add(new Face(Sean,Bandit));
		sq.add(new SetLeft(Bandit));
		sq.add(new SetRight(Sean));
		sq.add(new SetDialog("Give me all of your belongings!|I'm afraid I can't do that"));
		sq.add(new ShowDialog());
		sq.add(new WalkTo(Bandit,Sean));
		sq.add(new Draw(Bandit,Sword));
		sq.add(new Draw(Sean,Sword));
		sq.add(new Attack(Bandit,Sean));
		return sq;
	}
	
	private ActionSequence getGameOverDieSpookyPath() {
		var sq = new ActionSequence();
		var Sean = clist.get(Cnames.Sean);
		var Bandit = clist.get(Cnames.Bandit);
		var Sword = ilist.get(Inames.Sword);
		var SpookyPath = plist.get(Pnames.SpookyPath);
		sq.add(new HideDialog());
		sq.add(new Die(Sean));
		sq.add(new SetNarration("The Bandit outdueled you and you died a slow painful death bleeding out in the spookypath :("));
		sq.add(new ShowNarration());
		return sq;
	}
	
	
	@Override
	public INode getRoot() {
		var Sean = clist.get(Cnames.Sean);
		var Princess = clist.get(Cnames.Princess);
		var Compass = ilist.get(Inames.Compass);
		var CastleBedroom = plist.get(Pnames.CastleBedroom);
		var BlueBook = ilist.get(Inames.BlueBook);
		var Child = clist.get(Cnames.Child);
		var Soldier = clist.get(Cnames.Soldier);
		var Helmet = ilist.get(Inames.Helmet);
		var Sword = ilist.get(Inames.Sword);
		var Ruins = plist.get(Pnames.Ruins);
		var Warlock = clist.get(Cnames.Warlock);
		var AlchemyShop = plist.get(Pnames.AlchemyShop);
		var Alchemist = clist.get(Cnames.Alchemist);
		var Bandit = clist.get(Cnames.Bandit);
		var Camp = plist.get(Pnames.Camp);
		var Coin = ilist.get(Inames.Coin);
		var City = plist.get(Pnames.City);
		var Merchant = clist.get(Cnames.Merchant);
		var Blacksmith = clist.get(Cnames.Blacksmith);
		var SpookyPath = plist.get(Pnames.SpookyPath);
		var Dungeon = plist.get(Pnames.Dungeon);
		var Troll = clist.get(Cnames.Troll);
		var BlackSmith = plist.get(Pnames.BlackSmith);
		var Home = plist.get(Pnames.CastleBedroom);

		
		var GameOverDieSpookyPathNode = new Node(NodeLabels.GameOverDieSpookyPath.toString());

		
		var AttackBanditSpookyPathNode = new Node(NodeLabels.BanditSpookyPath.toString());
		AttackBanditSpookyPathNode.addChild(new ActionChoice(ChoiceLabels.BanditAttack.toString(),ActionChoice.Icons.swords), GameOverDieSpookyPathNode);

		
		var SpookyPathStartNode = new Node(NodeLabels.SpookyPathNode.toString());
		SpookyPathStartNode.addChild(new ActionChoice(ChoiceLabels.WalkToDirtPile.toString(),Bandit,ActionChoice.Icons.forest), AttackBanditSpookyPathNode);

		
		var GameOverCityNode = new Node(NodeLabels.GameOverCity.toString());
		

		var BlackSmithAttackNode = new Node(NodeLabels.BlackSmithAttack.toString());
		BlackSmithAttackNode.addChild(new ActionChoice(ChoiceLabels.WalkToBlueHouseDoorCity.toString(),ActionChoice.Icons.target), GameOverCityNode);

		
		var MerchantNode  = new Node(NodeLabels.BuySwordFromMerchant.toString());
		MerchantNode.addChild(new SelectionChoice(ChoiceLabels.AttackMerchant.toString()),BlackSmithAttackNode);
		MerchantNode.addChild(new SelectionChoice(ChoiceLabels.PocketSword.toString()),SpookyPathStartNode);
		
		
		var ArriveCityNode  = new Node(NodeLabels.CityNode.toString());
		ArriveCityNode.addChild(new ActionChoice(ChoiceLabels.WalkToMerchant.toString(),Merchant,ActionChoice.Icons.anvil),MerchantNode);

		
		var GetCoinsPrincessNode  = new Node(NodeLabels.RevivePrincess.toString());
		GetCoinsPrincessNode.addChild(new ActionChoice(ChoiceLabels.ArriveCity.toString(),Merchant,ActionChoice.Icons.shopsign), ArriveCityNode);

		
		var PrincessDieNode = new Node(NodeLabels.KneelandGivePrincessBlueBook.toString());
		PrincessDieNode.addChild(new ActionChoice(ChoiceLabels.PrincessDie.toString(),Coin,ActionChoice.Icons.coins), GetCoinsPrincessNode);

		
		var DieWarlockNode = new Node(NodeLabels.GameOverDieRuins.toString());

		
		var WarlockAttackNode = new Node(NodeLabels.WarlockDialog.toString());
		WarlockAttackNode.addChild(new ActionChoice(ChoiceLabels.WarlockAttack.toString(),Warlock,ActionChoice.Icons.skull), DieWarlockNode);
		
		
		var RuinsWarlockNode = new Node(NodeLabels.WalkToCampExit.toString());
		RuinsWarlockNode.addChild(new PositionChoice(Sean,Ruins.getName(),Condition.arrived),WarlockAttackNode);

		
		var RuinsToCampNode = new Node(NodeLabels.TakeBanditsLoot.toString());
		RuinsToCampNode.addChild(new PositionChoice(Sean,Camp.getName(),Condition.arrived), RuinsWarlockNode);

		
		var BanditRuinsNode = new Node(NodeLabels.WalkToBandit.toString());
		BanditRuinsNode.addChild(new ActionChoice(ChoiceLabels.AttackBandit.toString(),Bandit,ActionChoice.Icons.swords), RuinsToCampNode);

		
		var SellBookNode = new Node(NodeLabels.SellBookForCoins.toString());
		SellBookNode.addChild(new PositionChoice(Sean,AlchemyShop.getName(),Condition.arrived), BanditRuinsNode);

		
		var UnpocketBlueBookNode = new Node(NodeLabels.AlchemyShopNode.toString());
		UnpocketBlueBookNode.addChild(new ActionChoice(ChoiceLabels.UnpocketBlueBook.toString(),Alchemist,ActionChoice.Icons.book), SellBookNode);

		
		var LeaveCastleNode = new Node(NodeLabels.WalkToCastleBedroomDoor.toString());
		LeaveCastleNode.addChild(new PositionChoice(Sean,AlchemyShop.getName(),Condition.exited),UnpocketBlueBookNode);

		
		var RunAwayNode = new Node(NodeLabels.GameOverRun.toString());
		
		
		var AttackedBySoldierNode = new Node(NodeLabels.SoldierAttack.toString());
		AttackedBySoldierNode.addChild(new ActionChoice(ChoiceLabels.Run.toString(),Child,ActionChoice.Icons.stonepath), RunAwayNode);

		
		var SoldierChoiceNode = new Node(NodeLabels.SoldierDialog.toString());
		SoldierChoiceNode.addChild(new SelectionChoice(ChoiceLabels.AttackSoldier.toString()), AttackedBySoldierNode);
		SoldierChoiceNode.addChild(new SelectionChoice(ChoiceLabels.GiveSoldierHelm.toString()), RuinsWarlockNode);
		
		
		var AttackChildNode = new Node(NodeLabels.ClapChild.toString());
		AttackChildNode.addChild(new ActionChoice(ChoiceLabels.AttackChild.toString(),Child,ActionChoice.Icons.fist), AttackedBySoldierNode);

		
		var ChildDanceNode = new Node(NodeLabels.GiveChildCompass.toString());
		ChildDanceNode.addChild(new ActionChoice(ChoiceLabels.DanceWithChild.toString(),Child,ActionChoice.Icons.music), AttackChildNode);

		
		var AttackDummyNode = new Node(NodeLabels.ShowSoldierSkills.toString());
		AttackDummyNode.addChild(new ActionChoice(ChoiceLabels.AttackDummy.toString(),Soldier,ActionChoice.Icons.sword), SoldierChoiceNode);

		
		var StartCampNode = new Node(NodeLabels.CampArrived.toString());
		StartCampNode.addChild(new SelectionChoice(ChoiceLabels.TalkToChild.toString()), ChildDanceNode);
		StartCampNode.addChild(new SelectionChoice(ChoiceLabels.TalkToSoldier.toString()), AttackDummyNode);

		
		var WalkToTableNode = new Node(NodeLabels.PickUpBlueBook.toString());
		WalkToTableNode.addChild(new ActionChoice(ChoiceLabels.PocketBlueBook.toString(),BlueBook,ActionChoice.Icons.scroll), LeaveCastleNode);
		WalkToTableNode.addChild(new ActionChoice(ChoiceLabels.LookAtBlueBook.toString(),BlueBook,ActionChoice.Icons.charm), PrincessDieNode);

		
		var WalkToCastleBedroomDoorNode = new Node(NodeLabels.ExitCastleBedroom.toString());
		WalkToCastleBedroomDoorNode.addChild(new PositionChoice(Sean,CastleBedroom.getName(),Condition.exited),StartCampNode);
		
		
		var rejectNode = new Node(NodeLabels.IgnorePrincess.toString());
		rejectNode.addChild(new ActionChoice(ChoiceLabels.WalkToTable.toString(),BlueBook,ActionChoice.Icons.book), WalkToTableNode);
		rejectNode.addChild(new ActionChoice(ChoiceLabels.WalkToCastleBedroomDoor.toString(), Sean,ActionChoice.Icons.campfire), WalkToCastleBedroomDoorNode);
		
		
		
		var PostDungeonWakeUp2 = new Node(NodeLabels.PostDungeonWakeUp2.toString());
		var PostDungeonWakeUp1 = new Node(NodeLabels.PostDungeonWakeUp1.toString());
		var DungeonWakeUp = new Node(NodeLabels.DungeonWakeUp.toString());
		var BlacksmithScene2 = new Node(NodeLabels.BlacksmithScene2.toString());
		var ReviveAfterCourtyard = new Node(NodeLabels.ReviveAfterCourtyard.toString());
		var CourtYard = new Node(NodeLabels.CourtYard.toString());
		var ReviveAfterRuins = new Node(NodeLabels.ReviveAfterRuins.toString());
		var RuinsSorcerer = new Node(NodeLabels.RuinsSorcerer.toString());
		var DungeonTable = new Node(NodeLabels.DungeonTable.toString());
		var DungeonChest = new Node(NodeLabels.DungeonChest.toString());
		var PrincessExit = new Node(NodeLabels.PrincessExit.toString());
		var TalkToPrincess2 = new Node(NodeLabels.TalkToPrincess2.toString());
		var AlchemyShopScene = new Node(NodeLabels.AlchemyShopScene.toString());
		var ExitBridge = new Node(NodeLabels.ExitBridge.toString());
		var BridgeScene = new Node(NodeLabels.BridgeScene.toString());
		var ExitBlackSmith = new Node(NodeLabels.ExitBlackSmith.toString());
		var BlacksmithScene = new Node(NodeLabels.BlacksmithScene.toString());
		var ExitHome = new Node(NodeLabels.ExitHome.toString());
		var TalkToPrincess = new Node(NodeLabels.TalkToPrincess.toString());
		var Start = new Node(NodeLabels.Start.toString());
		var Init = new Node(NodeLabels.Init.toString());
		CourtYard.addChild(
		new SelectionChoice("Chest"),ReviveAfterCourtyard);
		DungeonTable.addChild(
		new SelectionChoice("Table"),CourtYard);
		RuinsSorcerer.addChild(
		new SelectionChoice("Stay"),ReviveAfterRuins);
		DungeonTable.addChild(
		new PositionChoice(
		Sean,
		Ruins.getName(),
		PositionChoice.Condition.arrived),RuinsSorcerer);
		PrincessExit.addChild(
		new SelectionChoice("Table"),DungeonTable);
		PrincessExit.addChild(
		new SelectionChoice("Chest"),DungeonChest);
		ExitBridge.addChild(
		new SelectionChoice("Yes"),AlchemyShopScene);
		TalkToPrincess2.addChild(
		new SelectionChoice("Steal"),PrincessExit);
		DungeonWakeUp.addChild(
		new SelectionChoice("Get your own money!"),PostDungeonWakeUp1);
		DungeonWakeUp.addChild(
		new SelectionChoice("Give Coin"),PostDungeonWakeUp2);
		BlacksmithScene2.addChild(
		new PositionChoice(
		Sean,
		Dungeon.getName(),
		PositionChoice.Condition.arrived),DungeonWakeUp);
		BridgeScene.addChild(
		new ActionChoice("Attack",Troll,ActionChoice.Icons.swords),ExitBridge);
		ExitBlackSmith.addChild(
		new ActionChoice("WalkTo",Troll,ActionChoice.Icons.swords),BridgeScene);
		BlacksmithScene.addChild(
		new SelectionChoice("Buy"),ExitBlackSmith);
		BlacksmithScene.addChild(
		new SelectionChoice("Steal"),BlacksmithScene2);
		ExitHome.addChild(
		new PositionChoice(
		Sean,
		BlackSmith.getName(),
		PositionChoice.Condition.arrived),
		BlacksmithScene);
		TalkToPrincess.addChild(
		new SelectionChoice("Steal"),TalkToPrincess2);
		TalkToPrincess.addChild(
		new SelectionChoice("Dance"),ExitHome);
		
		var CastleBedroomNode = new Node(NodeLabels.CastleBedroom.toString());
		CastleBedroomNode.addChild(new SelectionChoice(ChoiceLabels.Reject.toString()),rejectNode);
		CastleBedroomNode.addChild(new SelectionChoice(ChoiceLabels.Accept.toString()), TalkToPrincess);
		
		Start.addChild(
		new PositionChoice(
		Sean,
		Home.getName(),
		PositionChoice.Condition.arrived),
		CastleBedroomNode);
		Init.addChild(new SelectionChoice("Start"), Start);

		return Init;
	}
	
}