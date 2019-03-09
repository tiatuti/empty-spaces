

public enum preferences{
    usesCommonArea("uses common area", true),
    bringTV("bringing TV", true),
    bringInTVStand("bring In TV stand", true),
    bringInSeatingForGuests("bring In Seating For Guests", true),
    doesHWinCommonRoom("doesHWinCommonRoom", false),
    eatInRoom("eatInRoom", true),
    wantViewEating("wantViewEating", true),
    throwParties("throw parties", true),
    praysInRoom("praysInRoom", false),
    drinksCoffeeInRoom("drinksCoffeeInRoom", false),
    wantView("wants View", true),
    wantNaturalLight("wantNaturalLight", true),
    chargePhoneInRoom("charge Phone In Room", true),
    entranceNarrow("entrance narrow", true),
    splitRoomFromKitchen("splitRoomFromKitchen", false),
    haveGuestsFrequently("haveGuestsFrequently", false),
    bringSportsEquipment("bringSportsEquipment", false);


    private String name;
    private boolean flag;

    preferences(String name, boolean flag){
        this.name = name;
        this.flag = flag;
    }

    public void change(boolean flag) {

         this.flag = flag;
    }

    public boolean getPref() {

         return this.flag;
    }
    public boolean getBoolean() {

        return this.flag;
    }

    public String getName() {

        return this.name;
    }
}
