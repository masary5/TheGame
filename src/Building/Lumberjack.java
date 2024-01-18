/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Building;

import Map.player;

/**
 *
 * @author guest-a9khel
 */
public class Lumberjack extends Building {
    //Abbaugeschwindigkeit des Holzes in holz pro runde
    int chopspeed;

    public Lumberjack(int xPosition, int yPosition) {
    this.xPosition=xPosition;
    this.yPosition=yPosition;
    this.buildtime=3;
    this.healthpoints=3;
    this.buildingrange=4;
    this.buildcost[0]=5;
    this.chopspeed = 1;
    }
    
    public boolean buildable(player player) {
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
 
    //anfang jeder runde Holz faellen
  public void woodchop(player player) {
      player.setWood(player.getWood()+chopspeed);
  }
}
