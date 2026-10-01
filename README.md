<span class=""><strong>Introduction</strong><br>This mod aims to remove the mechanic where, after eating the Celestial Fruit from Enigmatic Legacy, Enigmatic Delicacy applies Starry Drunkenness to you.</span>

**<span class="">What is Starry Drunkenness?</span>**  
<span class="">1.Each level reduces damage dealt by 5%; at level V and above, this becomes a 40% reduction.</span>  
<span class="">2.Each level increases critical damage by 10%.</span>  
<span class="">3.Each level reduces attack speed by 5%.</span>  
<span class="">4.Each level increases the time required to eat by 15%.</span>  
<span class="">5.The particle effects on the player become randomly colored.</span>  
<span class="">6.Under normal circumstances, it cannot be removed.</span>  
<span class="">7.When the effect reaches level V or above:</span>  
     <span class="">&nbsp; &nbsp; &nbsp;Continuously removes positive effects from the player.</span>  
     <span class="">&nbsp; &nbsp; &nbsp;Continuously applies Nausea and Hunger III.</span>  
     <span class="">&nbsp; &nbsp; &nbsp;Deals 2 points of hunger damage every 0.5 seconds.</span>

<span class="">Source:</span>  
<span class="">Eating Celestial Fruit-related foods (controlled by the celestial_fruit_food tag):</span>  
<span class="">The first consumption grants the effect for 360 seconds.</span>  
<span class="">Subsequent consumption extends the effect by 180 seconds and increases its level by 1.</span>  
<span class="">When at level IV or above, each consumption grants a fixed 180 seconds of the level V effect.</span>

_<span class="">Also, there is a compatibility issue with Apotheosis's Potion Charm: removing the buff granted by the Potion Charm causes a crash.<br>This buff cannot be locked by commands, cannot be removed by the mod's own command, and cannot be cleared by other conventional means, such as the Magic Quartz Flower from Enigmatic Legacy: Expansion, Cleanse from Iron's Spells 'n Spellbooks, or vanilla milk.<br>Before using this mod, it could only be removed by death or by High-Calcium Milk from Star Meow Craft.</span>_

<span class="">Based on player community feedback (including my own), this effect did not achieve the goal of balancing Celestial Fruit-related foods; instead, it made the game experience va</span> undefinedcommand to remove this effect.

中文版

本mod旨在移除当食用神秘遗物模组的天体果实之后，神秘佳肴会给你附加星辉酩酊的机制。
何为星辉酩酊？
每级减少 5% 造成的伤害，Ⅴ级及以上变为减少 40%；
每级增加 10% 暴击伤害；
每级减少 5% 攻击速度；
每级增加 15% 进食所需时间；
玩家身上的粒子效果将变为不定的彩色；
一般情况下无法被清除；
当效果达到Ⅴ级及以上时：
持续清除身上的正面效果；
持续获得反胃和饥饿Ⅲ效果；
每 0.5 秒收到2点饥饿伤害。
来源：
食用天体果实相关食物（由 celestial_fruit_food 标签控制）：
初次食用会获得 360 秒的该效果；
此后食用会延长效果 180 秒并使效果提升一级；
当大于等于Ⅳ级时，每次将会固定获得 180 秒的Ⅴ级效果。

同时，和神化的药水护符有兼容问题，清除药水护符给予的buff会导致崩溃
这个buff无法被指令锁定，模组自带的指令也无法移除，也无法通过其他常规手段清除。如使用神秘遗物扩展的魔法石英花,铁魔法的净化，原版的牛奶。在使用这个mod之前只能通过死亡与星喵工艺里的高钙奶清除。

并根据玩家社区反馈(包括我)，表明这个效果没有起到平衡天体果实相关食物的效果，反而使得游戏体验很差。

所以这个mod移除了这个机制，并添加了/removesd命令由于移除这个效果
