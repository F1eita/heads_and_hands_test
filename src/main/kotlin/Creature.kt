class Damage(var minDamage: Int, var maxDamage: Int){
    init{
        if (minDamage > maxDamage){
            val temp = maxDamage
            maxDamage = minDamage
            minDamage = temp
        }
        require(minDamage > 0)
    }
}

open class Creature(val name: String,
                    val attack: Int,
                    val defense: Int,
                    val maxHealth: Int,
                    val damage: Damage){

    var currHealth = maxHealth

    init{
        require(attack in 0..30)
        require(defense in 0..30)
        require(maxHealth > 0)
    }

    fun toAttackSomebody(victim: Creature): Int?{
        if (currHealth <= 0) return null
        var attackModifier = attack - victim.defense + 1
        if (attackModifier < 0) attackModifier = 1
        for (i in 1..attackModifier){
            val result = (1..6).random()
            if (result >= 5){
                return ((damage.minDamage) .. (damage.maxDamage)).random()
            }
        }
        return 0
    }

    open fun toGetDamage(damage: Int){
        currHealth -= damage
        if (currHealth <= 0){
            currHealth = 0
            println("$name is defeated!")
        }

    }

}