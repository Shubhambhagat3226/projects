package game.ImproveUsingGUI;

import game.ImproveUsingGUI.weapons.SuperWeapon;

public class Player {

    int hp;
    SuperWeapon currentWeapon;

    public void setHp(int health, UI ui) {
            hp += health;
        ui.hpLabelNumber.setText(Integer.toString(hp));
    }

    public void setCurrentWeapon(SuperWeapon currentWeapon, UI ui) {
        this.currentWeapon = currentWeapon;
        ui.weaponLabelName.setText(currentWeapon.getName());
    }
}
