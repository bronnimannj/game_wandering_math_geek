# game_wandering_math_geek

## Table of contents

- [Motivations](#motivations)
- [Project description](#description)
- [Visuals](#visuals)
- [Packages used](#packages_used)
- [Instructions](#instructions)
- [Files](#files)
- [Possible improvements](#improvements)
- [Credits](#credits)
- [License](#license)
- [Status](#status)


## Motivations <a name="motivations"></a>

This project was first a Bachelor project I created with a classmate in Java, to apply our class's teachings.

This is a small game created about a wanderer geek trying to solve puzzles

## Project description <a name="description"></a>

This application is 100% created using Java.

The code reads txt files containing labyrinth forms and builds an app. 
The Player plays a Geek, a "creature" that tried to survives seasons. 
Each season has its own drawbacks:

- Spring has traps that will bring points if you find them
- Summer has a count limit on how many steps you can take
- Fall has walls of leaves that are created behind each step you take
- Winter has frozen the floor and you will glide each step into the opposite wall.

The goal of the game is to survive each season for 3 year / level. At the end of your ordeal, a count of your points will be done.


## Visuals <a name="visuals"></a>

Here are an example of each season, at the first level:

![Spring](https://github.com/jmballard/game_wandering_math_geek/blob/main/visuals/spring_level1.png?raw=true "Spring")
![Summer](https://github.com/jmballard/game_wandering_math_geek/blob/main/visuals/summer_level1.png?raw=true "Summer")
![Fall](https://github.com/jmballard/game_wandering_math_geek/blob/main/visuals/fall_level1.png?raw=true "Fall")
![Winter](https://github.com/jmballard/game_wandering_math_geek/blob/main/visuals/winter_level1.png?raw=true "Winter")


## Packages used <a name="packages_used"></a>

- java.awt.BorderLayout
- java.awt.Dimension
- java.awt.Graphics
- java.awt.Image
- java.awt.event.KeyAdapter
- java.awt.event.KeyEvent
- java.io.BufferedReader
- java.io.BufferedWriter
- java.io.FileReader
- java.io.FileWriter
- java.util.Vector
- javax.swing.ImageIcon
- javax.swing.JOptionPane
- javax.swing.JPanel


## Instructions <a name="instructions"></a>

You can clone this repository by opening Git Bash and the command line

```text
git clone https://github.com/jmballard/game_wandering_math_geek.git
```

Then you can open this folder within your IDE (for example Eclipse) and run the project.

## Files <a name="files"></a>

The main files are in the "game/src" folder. It contains all the source code:

```text
- Arrow.java
- BestScores.java
- Button.java
- Elements.java
- Empty.java
- Entry.java
- Exit.java
- Fixes.java
- Game.java
- Gamer.java
- Labyrinth.java
- Objects.java
- Picking.java
- Player.java
- Traps.java
- Wall.java
- WanderingGeek.java
```

The folder "game/src/geek" contains jpgs of our character with the correct season's background.

The folder "game/src/misc" contains jpgs of every picture needed by the game.

The folder "game/src/seasons" contains the background of each season.

The folder "game/src/texts" contains the text files that are used to load the labyrinths.

The file "game/BestScores.txt" contains the current best scores of the game. Is updated each time someone finishes the game.

The file "game/Original_bestscores.txt" contains the original best scores. Can be used to reset the best scores if we want to.

The folder "visuals" contains the visuals needed above.

The other files (gitignore, LICENSE and README) are usual repo files.

## Possible improvements on this project: <a name="improvements"></a>

List of possible improvements:

- Make more levels
- Create different types of traps
- Improve on the scoring ideas
- Update the pictures to be nicer on the eye (they were created in 2009)


## Credits <a name="credits"></a>

This project was first created as part of a Bachelor course in Java programmation. 
The classmate who worked with me on this project is Zoe B. The project was firstly built in French.

## License <a name="license"></a>

MIT License

Copyright (c) [2022] [Julie Ballard]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.


## Project status  <a name="status"></a>

This project is currently stopped. As while it was fun while updating it slightly, it is not where my main focus is currently on.