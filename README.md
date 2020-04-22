# Maze-1809 走迷宫游戏


#### 技术：
  利用java以及算法基础来实现一个迷宫<br>
  
#### 实现的思路：

##### 1. 算法：
   算法采用的是随机生成迷宫,每次打开游戏 迷宫起点到终点固定，但路径都能发生变化 <br>
   
* 1.1 生成算法：   
   先将起点 终点 分别定死在 左上角以及右下角 e.g.: 地图大小50x50 起点(1,1) 终点(49,49);<br>
   然后使用递归算法生成路径：路径可以分为 上 下 左 右 四个方向 其中在随机生成的方向过程中 可以提高随机出 右 下 方向的几率<br>
                          当路径生成的过程中，还需要将生成出来的方向进行标记 完毕后使用Swing来生成路径以及墙壁<br>
                          
* 1.2 求解算法
   参考 《数据结构》（C语言版）严蔚敏，吴伟民 著中 对迷宫求解的伪代码，使用Stack来求解成功路径 <br>
   
##### 2. 界面
   界面使用Swing来布局 使用 WASD 来控制 前后左右 每一次移动将布局重新刷新 达到动态的效果<br>
  
