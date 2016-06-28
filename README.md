# Bowling Game

This test is to write a program for a bowling game.
This bowling game is a ten-pin bowling. A bowler has ten frames to knock down pins. In each of one to nine frames, the bowler makes one or two throws while the tenth frame has up to three throws.
You program should be able to receive an array of arrays of pins knocked down by each throw as an input. Each number should always be an integer between 0 and 10.
[[5,2],[8,1],[6,4],[10],[0,5],[2,6],[8,1],[5,3],[6,1],[10,2,6]]
Each sub-array represents one frame of a game.
This bowling game is unique. The basic rules of this bowling game are:
- No additional score for a spare.
- If a bowler knocks down all ten pins on the first throw, it’s a strike. A strike is worth 10, plus the score in the next frame if the next frame is not a strike. If the next frame is also a strike, which means the bowler has made two strikes, then the score from the third frame is also added to the first frame.
Ex. 10 (first frame)+10 (second frame)+10 (third frame) results in the first frame with a score of 30.
Ex. 10 (first frame)+6 (second frame) results in the first frame with a score of 16.
- If a strike is not made in a frame, the score of the frame is just the sum of pins knocked down.
- The last frame has up to three throws. If a bowler had a strike on the first throw, the bowler is allowed to have one additional throw. So the bowler has three throws in total. If the bowler made two strikes
Your program output an array of integers representing the total scores at the end of each frame.
[7,16,26,35,40,48,57,65,72,88]
What we are interested in are:
- How you design classes and methods.
- How you test.
- How you handle unexpected behaviour such as invalid input, e.g what would happen if the input was not an array of array.
As long as the above basic rules of this bowling games are followed, the functionality is ok even if it differs from typical rules of a bowling game.
If there are anything you don’t understand, leave your comments when you email us final code.
You can write code in any programming language you like.
Your program doesn’t need to be executable. We don’t execute it.
We don’t need GUI. Your program is called from some other programs and you just return an array of array.
Please zip your code and email to system@open8.com
OPEN8 Singapore Pte. Ltd.