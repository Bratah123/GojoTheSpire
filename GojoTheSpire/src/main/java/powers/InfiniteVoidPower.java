package powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class InfiniteVoidPower extends AbstractPower {
    public static final String POWER_ID = "InfiniteVoidPower";
    public static final String NAME = "Infinite Void";

    public InfiniteVoidPower(AbstractCreature owner) {
        this.name = NAME;
        this.ID = POWER_ID;
        this.owner = owner;
        this.type = AbstractPower.PowerType.BUFF;
        this.isTurnBased = false;
        this.priority = 90;
        this.description = "Gain [G] everytime a card is played.";

        // The image that shows up at bottom of character when used
        this.img = new Texture("img/gojo/powers/"+POWER_ID+".png");
    }

    @Override
    public void onPlayCard(AbstractCard card, AbstractMonster m) {
        super.onPlayCard(card, m);
        AbstractPlayer player = AbstractDungeon.player;
        player.gainEnergy(1);
    }
}
