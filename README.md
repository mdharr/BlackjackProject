# Blackjack Project

# Description
The project for week 4 for of Java is building the card game Blackjack. For those unfamiliar with the rules of the game, There are two players, the user player and the dealer. The dealer controls the deck of cards and is in charge of dealing to both itself and the user player. When the game starts, the dealer creates a deck of 52 cards, shuffles said deck, deals a card to the user player, a card to itself (face down), another card to the user player, and a final card to itself (face up). The goal of the game is to get as close to 21 as possible without going over it. If the user or dealer goes over 21, the automatically lose. If the dealer reaches at least 17 points, the can be dealt no further cards for the remained of the round. The user is then faced with a choice, 'hit' or 'stand'. Choosing hit will deal the user another card, while stand will then proceed to the dealer choosing to hit or stand. The user can choose 'hit' as many times as they wish until they exceed 21, at which point it is considered a 'bust', in other words they lose the round. After playing each round, the user can choose if they wish to continue. By continuing, they will keep the same deck and the dealer will deal another 2 cards per player. Rounds can be played until the there are less than 10 cards remaining in the deck. This will then trigger the dealer to create a fresh deck and the game begins anew.

# Technologies Used
Java, Git, GitHub, Atom, Eclipse

# What I Learned
I'll start off with an analogy to describe my biggest realization while building this application. Building an application, shares many similarities with building a house. You need to first have a blueprint and know what materials you will need, much like needing to map out the structure of your application along with the different classes, interfaces, enums, and your main. Next you need to lay your foundation, like planning out your class hierarchy, ensuring proper encapsulation, what methods you will need to write as dry of code as possible, and not only making sure each class serves a specific purpose, but also creating classes and objects in a way that is reusable in future projects. Lastly, you begin to the building process (putting it all together), or in programming speak, you start to fill in the logic. The logic is ultimately the glue that will connect and stick everything together. My favorite moment in this project was towards the end, when I encountered a bug that revealed the dealer up to that point wasn't the dealer at all, it was the deck itself! I had to figure out a way to instantiate a deck object that belonged to the dealer. An object that was only touched by the dealer. After a few mins (actually hours) of tinkering, I discovered that I could not only instantiate a new deck object, a new blackjack hand, and a dealer in the same line of code, but it was ALL WITHIN THE DEALER'S CONSTRUCTOR!!! Needless to say, it was a big win. I would struggle all over again if I had to remake this project, but I am confident that I could build this application faster, and perhaps even a bit cleaner. There are several nested while loops that I'm not too happy with, but hey, I got it to run from start to finish!