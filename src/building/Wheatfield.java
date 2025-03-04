package building;

import map.Player;
import tools.MiscUtils;

public class Wheatfield extends Building {

    //Feld gibt Motivationsboost durch "Nahrung"
    double motivationboost;
    //Abklingzeit für harvest, vlt. Änderung im Erscheinungsbild wenn der Weizen wächst
    int cooldown=1;
    //maximale cooldown-Zeit
    private int maxcooldowntime = 4;

    public Wheatfield(String playername, int xPosition, int yPosition) {
        super(playername); 
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.buildtime = 2;
        this.healthpoints = 2;
        this.buildingrange = 2;
        this.motivationboost = 1.0;
        
        
        picture = MiscUtils.loadImages("src/gui/res/building/")[2];

        // this.info="Ein endloses Weizenfeld erstreckt sich vor dir, goldene Ähren wiegen sich im Wind. Zwischen den Reihen verlaufen Pfade, auf denen Bauern die reiche Ernte einbringen. Die Arbeit hier ist nicht nur körperlich, sondern stärkt auch den Zusammenhalt. Die erfolgreiche Ernte gibt den Truppen einen spürbaren Motivationsboost, da sie nicht nur Nahrung, sondern auch ein Gefühl von Gemeinschaft und Kampfgeist gewinnen.";
        // this.TeamId=TeamId;
    }

    public boolean buildable(Player player) {
        // Wood und Stone vom player
        int wood = player.getWood();
        int stone = player.getStone();

        if (wood >= 1 && stone >= 1) {
            // Kosten des Bauens: 1 wood, 1 Stone
            player.setWood(wood - 1);
            player.setStone(stone - 1);
            // genug ressourcen, deswegen buildable true
            return true;
        }
        // bei false, soll das Gebäude nicht gebaut werden
        return false;
    }

    public void harvest(Player player) {
        //nur möglich, wenn der cooldown abgelaufen ist - Erntezeit
        cooldown--;
        if (cooldown <= 0) {
            //motivationsboost
            //this.motivationboost = this.motivationboost * 1.01;
            player.setFood(player.getFood()+16);
            this.cooldown = maxcooldowntime;
        } else {
            //Ausgabe, dass der Cooldown noch nicht abgelaufen ist.
        }
    }

}
