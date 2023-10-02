fun main(args: Array<String>) {
    val player1 = Player("pro3000",30, 15, 100, Damage(5, 10))
    val monster1 = Monster("Zombie", 20, 20, 50, Damage(20, 25))

    while(player1.currHealth * monster1.currHealth != 0){
        val damageByPlayer = player1.toAttackSomebody(monster1) ?: break
        baseState(player1, monster1)
        firstCrAttacks(player1, monster1)
        secondCrGetsDamage(player1, monster1, damageByPlayer)
        monster1.toGetDamage(damageByPlayer)
        val damageByMonster = monster1.toAttackSomebody(player1) ?: break
        baseState(player1, monster1)
        secondCrAttacks(player1, monster1)
        firstCrGetsDamage(player1, monster1, damageByMonster)
        player1.toGetDamage(damageByMonster)
    }

}

fun baseState(creature1: Creature, creature2: Creature){
    println("""
        
        |${creature1.name}| (o-o)           (*-*) |${creature2.name}|
         | ${creature1.currHealth} |                         | ${creature2.currHealth} |        
        """.trimIndent())
    Thread.sleep(1250L)
}

fun secondCrGetsDamage(creature1: Creature, creature2: Creature, damage: Int){
    println("""
        
        |${creature1.name}| (o-o)        ${-damage} (*-*) |${creature2.name}|
         | ${creature1.currHealth} |                         | ${creature2.currHealth} |        
        """.trimIndent())
    Thread.sleep(750L)
}

fun firstCrGetsDamage(creature1: Creature, creature2: Creature, damage: Int){
    println("""
        
        |${creature1.name}| (o-o) ${-damage}        (*-*) |${creature2.name}|
         | ${creature1.currHealth} |                        | ${creature2.currHealth} |        
        """.trimIndent())
    Thread.sleep(750L)
}

fun firstCrAttacks(creature1: Creature, creature2: Creature){
    println("""
        
        |${creature1.name}|          (o-o)->(*-*) |${creature2.name}|
         | ${creature1.currHealth} |                         | ${creature2.currHealth} |        
        """.trimIndent())
    Thread.sleep(500L)
}

fun secondCrAttacks(creature1: Creature, creature2: Creature){
    println("""
        
        |${creature1.name}| (o-o)<-(*-*)          |${creature2.name}|
         | ${creature1.currHealth} |                         | ${creature2.currHealth} |        
        """.trimIndent())
    Thread.sleep(500L)
}