class Player(name: String,
             attack: Int,
             defense: Int,
             fullHealth: Int,
             damage: Damage): Creature(name, attack, defense, fullHealth, damage) {

    private var countTreatments = 4

    fun toGetTreatment(){
        if (countTreatments > 0){
            currHealth += (0.3 * maxHealth).toInt()
            if (currHealth > maxHealth) currHealth = maxHealth
            countTreatments--
            println("$name got treatment")
        }
    }

    override fun toGetDamage(damage: Int) {
        super.toGetDamage(damage)
        if (currHealth in (0..(maxHealth * 0.7).toInt())){
            toGetTreatment()
        }
    }
}