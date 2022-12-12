package hae.nerf.db;

public class ChampionDetailVO {
	private String id;
	private String key;
	private String name;
	private String title;
	private String blurb;
	private String attack;
	private String defense;
	private String magic;
	private String difficulty;
	private String image;
	private String partype;
	private String hp;
	private String hpperlevel;
	private String mp;
	private String mpperlevel;
	private String movespeed;
	private String armor;
	private String armorperlevel;
	private String spellblock;
	private String spellblockperlevel;
	private String attackrange;
	private String hpregen;
	private String hpregenperlevel;
	private String mpregen;
	private String mpregenperlevel;
	private String crit;
	private String critperlevel;
	private String attackdamage;
	private String attackdamageperlevel;
	private String attackspeedperlevel;
	private String attackspeed;
	
	
	
	
	public String getMp() {
		return mp;
	}
	public void setMp(String mp) {
		this.mp = mp;
	}
	public String getMpperlevel() {
		return mpperlevel;
	}
	public void setMpperlevel(String mpperlevel) {
		this.mpperlevel = mpperlevel;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBlurb() {
		return blurb;
	}
	public void setBlurb(String blurb) {
		this.blurb = blurb;
	}
	public String getAttack() {
		return attack;
	}
	public void setAttack(String attack) {
		this.attack = attack;
	}
	public String getDefense() {
		return defense;
	}
	public void setDefense(String defense) {
		this.defense = defense;
	}
	public String getMagic() {
		return magic;
	}
	public void setMagic(String magic) {
		this.magic = magic;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPartype() {
		return partype;
	}
	public void setPartype(String partype) {
		this.partype = partype;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getHpperlevel() {
		return hpperlevel;
	}
	public void setHpperlevel(String hpperlevel) {
		this.hpperlevel = hpperlevel;
	}
	public String getMovespeed() {
		return movespeed;
	}
	public void setMovespeed(String movespeed) {
		this.movespeed = movespeed;
	}
	public String getArmor() {
		return armor;
	}
	public void setArmor(String armor) {
		this.armor = armor;
	}
	public String getArmorperlevel() {
		return armorperlevel;
	}
	public void setArmorperlevel(String armorperlevel) {
		this.armorperlevel = armorperlevel;
	}
	public String getSpellblock() {
		return spellblock;
	}
	public void setSpellblock(String spellblock) {
		this.spellblock = spellblock;
	}
	public String getSpellblockperlevel() {
		return spellblockperlevel;
	}
	public void setSpellblockperlevel(String spellblockperlevel) {
		this.spellblockperlevel = spellblockperlevel;
	}
	public String getAttackrange() {
		return attackrange;
	}
	public void setAttackrange(String attackrange) {
		this.attackrange = attackrange;
	}
	public String getHpregen() {
		return hpregen;
	}
	public void setHpregen(String hpregen) {
		this.hpregen = hpregen;
	}
	public String getHpregenperlevel() {
		return hpregenperlevel;
	}
	public void setHpregenperlevel(String hpregenperlevel) {
		this.hpregenperlevel = hpregenperlevel;
	}
	public String getMpregen() {
		return mpregen;
	}
	public void setMpregen(String mpregen) {
		this.mpregen = mpregen;
	}
	public String getMpregenperlevel() {
		return mpregenperlevel;
	}
	public void setMpregenperlevel(String mpregenperlevel) {
		this.mpregenperlevel = mpregenperlevel;
	}
	public String getCrit() {
		return crit;
	}
	public void setCrit(String crit) {
		this.crit = crit;
	}
	public String getCritperlevel() {
		return critperlevel;
	}
	public void setCritperlevel(String critperlevel) {
		this.critperlevel = critperlevel;
	}
	public String getAttackdamage() {
		return attackdamage;
	}
	public void setAttackdamage(String attackdamage) {
		this.attackdamage = attackdamage;
	}
	public String getAttackdamageperlevel() {
		return attackdamageperlevel;
	}
	public void setAttackdamageperlevel(String attackdamageperlevel) {
		this.attackdamageperlevel = attackdamageperlevel;
	}
	public String getAttackspeedperlevel() {
		return attackspeedperlevel;
	}
	public void setAttackspeedperlevel(String attackspeedperlevel) {
		this.attackspeedperlevel = attackspeedperlevel;
	}
	public String getAttackspeed() {
		return attackspeed;
	}
	public void setAttackspeed(String attackspeed) {
		this.attackspeed = attackspeed;
	}
	
	
	@Override
	public String toString() {
		return "ChampionDetailVO [id=" + id + ", key=" + key + ", name=" + name + ", title=" + title + ", blurb="
				+ blurb + ", attack=" + attack + ", defense=" + defense + ", magic=" + magic + ", difficulty="
				+ difficulty + ", image=" + image + ", partype=" + partype + ", hp=" + hp + ", hpperlevel=" + hpperlevel
				+ ", movespeed=" + movespeed + ", armor=" + armor + ", armorperlevel=" + armorperlevel + ", spellblock="
				+ spellblock + ", spellblockperlevel=" + spellblockperlevel + ", attackrange=" + attackrange
				+ ", hpregen=" + hpregen + ", hpregenperlevel=" + hpregenperlevel + ", mpregen=" + mpregen
				+ ", mpregenperlevel=" + mpregenperlevel + ", crit=" + crit + ", critperlevel=" + critperlevel
				+ ", attackdamage=" + attackdamage + ", attackdamageperlevel=" + attackdamageperlevel
				+ ", attackspeedperlevel=" + attackspeedperlevel + ", attackspeed=" + attackspeed + "]";
	}
	
}
