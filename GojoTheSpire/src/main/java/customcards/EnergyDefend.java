package customcards;

import basemod.abstracts.CustomCard;
import color.AbstractCardEnum;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class EnergyDefend extends CustomCard {
    public static final String ID = "EnergyDefend";
    public static final String NAME = "Energy Defend";
    public static final String DESCRIPTION = "Gain !B! block for every energy stored.";
    public static final String IMG_PATH = "img/gojo/cards/gojo_energy_defend.jpg";
    public static final CardRarity RARITY = CardRarity.COMMON;
    public static final CardType CARD_TYPE = CardType.SKILL;
    private static final int COST = 2;
    private static final int BASE_BLOCk = 1;
    private static final int UPGRADED_BLOCK = 2;

    public EnergyDefend() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CARD_TYPE, AbstractCardEnum.GOJO_COLOR, RARITY, CardTarget.SELF);
        this.block = this.baseBlock = BASE_BLOCk;
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBlock(UPGRADED_BLOCK);
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster abstractMonster) {
        AbstractDungeon.actionManager.addToBottom(new GainBlockAction(p, p,
                this.block * p.getRelic("GojoBlindfold").counter));
    }
}
