import sys

import pygame
import random
import time
from pygame.sprite import *
import tkinter.messagebox as msgbox

SCREEN_WIDTH = 900
SCREEN_HEIGHT = 600
BG_COLOR = pygame.Color(0, 0, 0)
TXT_COLOR = pygame.Color(255, 0, 0)


class BaseItem(Sprite):
    def __init__(self, color, width, height):
        pygame.sprite.Sprite.__init__(self)


class MainGame():

    window = None
    my_tank = None
    # 存储敌方坦克列表
    enemyTankList = []
    # 定义敌方坦克数量
    enemyTankCount = 6
    # 存储我方子弹的列表
    myBulletList = []
    # 存储敌方子弹
    enemyBulletList = []
    # 存储爆炸对象
    explodeList = []
    # 存储墙壁的列表
    wallList = []

    def __init__(self):
        pass

    def start_game(self):
        # 初始化窗口
        pygame.display.init()
        # 设置窗口的大小及显示
        MainGame.window = pygame.display.set_mode([SCREEN_WIDTH, SCREEN_HEIGHT])
        # 初始化我方坦克
        self.createMyTank()
        # 初始化敌方坦克
        self.createEnemyTank()
        # 初始化墙壁
        self.createWall()
        # 设置窗口标题
        pygame.display.set_caption('坦克大战 1.01')
        while True:
            # 减慢坦克移动速度
            time.sleep(0.02)
            # 给窗口设置填充色
            MainGame.window.fill(BG_COLOR)
            # 获取事件
            self.get_event()
            # 绘制文字
            MainGame.window.blit(self.get_text_surface('敌方剩余坦克数量%d'%len(MainGame.enemyTankList)), (10, 10))
            # 当地方剩余坦克数量为0时游戏胜利
            if MainGame.my_tank and len(MainGame.enemyTankList) == 0:
                time.sleep(1)
                msgbox.showinfo('温馨提示', '你赢了！')
                sys.exit()

            if MainGame.my_tank and MainGame.my_tank.live:
                # 调用坦克显示方法
                MainGame.my_tank.displayTank()
            # 当我方坦克被击败时游戏结束
            else:
                # 删除我方坦克
                del MainGame.my_tank
                MainGame.my_tank = None
                time.sleep(1)
                msgbox.showinfo('温馨提示', '你输了!')
                sys.exit()



            # 调用敌方坦克展示
            self.blitEnemyTank()
            # 调用我方子弹显示
            self.blitMyBullet()
            # 调用敌方子弹显示
            self.blitEnemyBullet()
            # 调用爆炸效果
            self.blitExplode()
            # 展示墙壁
            self.blitWall()

            if MainGame.my_tank and MainGame.my_tank.live:
                # 调用坦克移动方法
                if not MainGame.my_tank.stop:
                    MainGame.my_tank.move()
                    # 检测是否与墙进行碰撞
                    MainGame.my_tank.hitWall()
                    # 检测我方坦克是否与敌方坦克发生碰撞
                    MainGame.my_tank.myTank_hit_enemyTank()

            pygame.display.update()

    def blitWall(self):
        for wall in MainGame.wallList:
            if wall.live:
                # 调用墙壁的显示方法
                wall.displayWall()
            else:
                # 从墙壁列表中移除
                MainGame.wallList.remove(wall)

    def createWall(self):
        for i in range(6):
            # 初始化墙壁
            wall = Wall(i*170, 220)
            # 将墙壁添加到列表中
            MainGame.wallList.append(wall)

    def createMyTank(self):
        MainGame.my_tank = MyTank(400, 300)
        # 创建Music对象
        music = Music('img/start.wav')
        # 播放音乐
        music.play()

    def blitExplode(self):
        for explode in MainGame.explodeList:
            if explode.live:
                explode.displayExplode()
            else:
                MainGame.explodeList.remove(explode)

    def blitMyBullet(self):
        # 循环遍历我方子弹存储列表
        for myBullet in MainGame.myBulletList:
            # 判断当前子弹是否碰到墙壁，如果碰到则从子弹列表中删除
            if myBullet.live:
                myBullet.displayBullet()
                myBullet.move()
                myBullet.myBullet_hit_enemyTank()
                # 检测子弹是否射中墙壁
                myBullet.hitWall()
            else:
                MainGame.myBulletList.remove(myBullet)

    def blitEnemyBullet(self):
        for enemyBullet in MainGame.enemyBulletList:
            if enemyBullet.live:
                enemyBullet.displayBullet()
                enemyBullet.move()
                # 判断敌方坦克子弹是否与我方坦克碰撞
                enemyBullet.enemyBullet_hit_myTank()
                # 检测敌方子弹是否与墙壁碰撞
                enemyBullet.hitWall()
            else:
                MainGame.enemyBulletList.remove(enemyBullet)

    def blitEnemyTank(self):
        # 循环遍历敌方坦克列表，展示敌方坦克
        for enemyTank in MainGame.enemyTankList:
            if enemyTank.live:
                # 未发生我方子弹击中，坦克显示
                enemyTank.displayTank()
                enemyTank.randMove()
                # 调用检测是否与墙壁进行碰撞
                enemyTank.hitWall()
                if MainGame.my_tank and MainGame.my_tank.live:
                    # 检测敌方坦克与我方坦克发生碰撞
                    enemyTank.enemyTank_hit_myTank()
                # 发射子弹
                enemyBullet = enemyTank.shot()
                if enemyBullet:
                    # 存储到子弹列表中
                    MainGame.enemyBulletList.append(enemyBullet)
            else:
                MainGame.enemyTankList.remove(enemyTank)


    def createEnemyTank(self):
        # 初始化敌方坦克，并将敌方坦克添加到列表中
        top = 100
        # 循坏生成敌方坦克
        for i in range(MainGame.enemyTankCount):
            left = random.randint(0, 600)
            speed = random.randint(1, 4)
            enemy = EnemyTank(left, top, speed)
            MainGame.enemyTankList.append(enemy)

    def end_game(self):
        print("游戏已经结束！")
        exit()

    def get_text_surface(self, text):
        # 初始化字体模块
        pygame.font.init()
        #获取字体对象
        font = pygame.font.SysFont('kaiti', 18)
        # 绘制文本信息
        text_surface = font.render(text, True, TXT_COLOR)
        return text_surface

    def get_event(self):
        # 获取所有事件
        event_list = pygame.event.get()
        # 遍历所有事件
        for event in event_list:
            # 是否按下退出键
            if event.type == pygame.QUIT:
                self.end_game()
            elif event.type == pygame.KEYDOWN:
                # 当我方坦克被敌方子弹击中
                if not MainGame.my_tank:
                    # 判断按下的是Esc键，让坦克重生
                    if event.key == pygame.K_ESCAPE:
                        # 让我方坦克重生
                        self.createMyTank()
                if MainGame.my_tank and MainGame.my_tank.live:
                    # 键盘按下，判断上下左右
                    if event.key == pygame.K_LEFT:
                        MainGame.my_tank.direction = 'L'
                        MainGame.my_tank.stop = False
                        print('坦克向左移动')
                    elif event.key == pygame.K_DOWN:
                        MainGame.my_tank.direction = 'D'
                        MainGame.my_tank.stop = False
                        print('坦克向下移动')
                    elif event.key == pygame.K_RIGHT:
                        MainGame.my_tank.direction = 'R'
                        MainGame.my_tank.stop = False
                        print('坦克向右移动')
                    elif event.key == pygame.K_UP:
                        MainGame.my_tank.direction = 'U'
                        MainGame.my_tank.stop = False
                        print('坦克向上移动')
                    elif event.key == pygame.K_SPACE:
                        # 创建我方坦克子弹，同时限制子弹的数量为3
                        if len(MainGame.myBulletList) < 3:
                            myBullet = Bullet(MainGame.my_tank)
                            MainGame.myBulletList.append(myBullet)
                            # 我方坦克发射子弹的音效
                            music = Music('img/hit.wav')
                            music.play()
                            print('发射子弹')
            elif event.type == pygame.KEYUP:
                # 键盘松开，坦克停止移动
                if event.key == pygame.K_UP or \
                    event.key == pygame.K_DOWN or \
                    event.key == pygame.K_LEFT or \
                    event.key == pygame.K_RIGHT:
                    if MainGame.my_tank and MainGame.my_tank.live:
                        MainGame.my_tank.stop = True


class Tank(BaseItem):
    # 设置坦克的位置
    def __init__(self, left, top):
        # 保存加载的图片
        self.images = {
            'U':pygame.image.load('img/p1tankU.gif'),
            'D':pygame.image.load('img/p1tankD.gif'),
            'L':pygame.image.load('img/p1tankL.gif'),
            'R':pygame.image.load('img/p1tankR.gif'),
        }
        # 方向
        self.direction = 'U'
        # 根据当前图片的方向获取图片Surface
        self.image = self.images[self.direction]
        # 根据该坦克图片所占矩形区域的大小
        self.rect = self.image.get_rect()
        # 设置该坦克图片的位置
        self.rect.left = left
        self.rect.top = top
        #设置坦克移动速度
        self.speed = 5
        # 坦克移动标志，默认为开启
        self.stop = True
        # 坦克是否显示
        self.live = True
        # 记录原来坐标
        self.oldLeft = self.rect.left
        self.oldTop = self.rect.top

    def move(self):
        # 移动后记录原始的坐标
        self.oldLeft = self.rect.left
        self.oldTop = self.rect.top
        # 判断坦克的方向进行移动
        self.image = self.images[self.direction]
        if self.direction == 'L':
            if self.rect.left > 0:
                self.rect.left -= self.speed
        elif self.direction == 'R':
            if self.rect.left + self.rect.height < SCREEN_WIDTH:
                self.rect.left += self.speed
        elif self.direction == 'U':
            if self.rect.top > 0:
                self.rect.top -= self.speed
        elif self.direction == 'D':
            if self.rect.top + self.rect.height < SCREEN_HEIGHT:
                self.rect.top += self.speed

    def shot(self):
        return Bullet(self)

    def stay(self):
        self.rect.left = self.oldLeft
        self.rect.top = self.oldTop

    def hitWall(self):
        # 循环遍历墙壁列表，判断坦克是否与墙壁进行碰撞
        for wall in MainGame.wallList:
            if pygame.sprite.collide_rect(self, wall):
                # 坦克不能移动
                self.stay()

    def displayTank(self):
        # 显示坦克
        MainGame.window.blit(self.image, self.rect)

class Wall():

    def __init__(self, left, top):
        # 加载墙壁图片
        self.image = pygame.image.load('img/steels.gif')
        # 获取墙壁的区域
        self.rect = self.image.get_rect()
        # 设置位置
        self.rect.left = left
        self.rect.top = top
        # 是否显示
        self.live = True
        # 设置生命值
        self.hp = 3

    def displayWall(self):
        MainGame.window.blit(self.image, self.rect)


class Music():
    def __init__(self, filename):
        self.filename = filename
        # 初始化音乐混合器
        pygame.mixer.init()
        # 加载音乐
        pygame.mixer.music.load(self.filename)

    def play(self):
        # 播放音乐
        pygame.mixer.music.play()


class EnemyTank(Tank):

    def __init__(self, left, top, speed):
        # 调用父类的初始化
        super(EnemyTank, self).__init__(left, top)
        # 加载图片集
        self.images = {
            'U':pygame.image.load('img/enemy1U.gif'),
            'D':pygame.image.load('img/enemy1D.gif'),
            'L':pygame.image.load('img/enemy1L.gif'),
            'R':pygame.image.load('img/enemy1R.gif')
        }
        # 设置敌方坦克的方向
        self.direction = self.randDirection()
        # 根据方向获取图片
        self.image = self.images[self.direction]
        # 获取坦克显示区域
        self.rect = self.image.get_rect()
        # 对left和top进行赋值
        self.rect.left = left
        self.rect.top = top
        # 对速度进行赋值
        self.speed = speed
        # 移动开关键,默认停止
        self.flag = True
        # 给敌方坦克增加一个固定的步数，用来改变方向
        self.step = 60

    def enemyTank_hit_myTank(self):
        if pygame.sprite.collide_rect(self, MainGame.my_tank):
            self.stay()

    def randMove(self):
        # 改变敌方坦克随机移动的方向
        if self.step < 0:
            # 修改方向
            self.direction = self.randDirection()
            self.step = 60
        else:
            self.move()
            # 步数递减
            self.step -= 1

    def randDirection(self):
        # 随机生成敌方坦克方向
        num = random.randint(1, 4)
        if num == 1:
            return 'U'
        elif num == 2:
            return 'D'
        elif num == 3:
            return 'L'
        elif num == 4:
            return 'R'

    def shot(self):
        # 随机生成100以内的数
        num = random.randint(1, 100)
        if num < 10:
            return Bullet(self)


class MyTank(Tank):

    def __init__(self, left, top):
        super(MyTank, self).__init__(left, top)


    def myTank_hit_enemyTank(self):
        # 循环遍历敌方坦克列表
        for enemyTank in MainGame.enemyTankList:
            if pygame.sprite.collide_rect(self, enemyTank):
                # 发生碰撞，不能动
                self.stay()


class Bullet(BaseItem):

    def __init__(self, tank):
        # 加载子弹图片
        self.image = pygame.image.load('img/enemymissile.gif')
        # 坦克的朝向决定子弹的发射的方向
        self.direction = tank.direction
        # 获取子弹显示区域
        self.rect = self.image.get_rect()
        # 子弹的left和top与方向有关
        if self.direction == 'U':
            self.rect.left = tank.rect.left + tank.rect.width/2 - self.rect.width/2
            self.rect.top = tank.rect.top - self.rect.height
        elif self.direction == 'D':
            self.rect.left = tank.rect.left + tank.rect.width/2 - self.rect.width/2
            self.rect.top = tank.rect.top + tank.rect.height
        elif self.direction == 'L':
            self.rect.left = tank.rect.left - self.rect.width
            self.rect.top = tank.rect.top + tank.rect.width/2 - self.rect.width/2
        elif self.direction == 'R':
            self.rect.left = tank.rect.left + tank.rect.height
            self.rect.top = tank.rect.top + tank.rect.width/2 - self.rect.width/2
        # 设置子弹的速度
        self.speed = 6
        # 子弹是否到达边界标志
        self.live = True

    def hitWall(self):
        # 循环遍历墙壁列表
        for wall in MainGame.wallList:
            if pygame.sprite.collide_rect(self, wall):
                # 子弹消失
                self.live = False
                # 墙壁的生命值减少
                wall.hp -= 1
                if wall.hp <= 0:
                    # 墙壁消失
                    wall.live = False


    def displayBullet(self):
        # 显示子弹
        MainGame.window.blit(self.image, self.rect)

    def move(self):
        if self.direction == 'U':
            if self.rect.top > 0:
                self.rect.top -= self.speed
            else:
                # 修改子弹状态
                self.live = False
        elif self.direction == 'D':
            if self.rect.top+self.rect.height < SCREEN_HEIGHT:
                self.rect.top += self.speed
            else:
                # 修改子弹状态
                self.live = False
        elif self.direction == 'L':
            if self.rect.left > 0:
                self.rect.left -= self.speed
            else:
                # 修改子弹状态
                self.live = False
        elif self.direction == 'R':
            if self.rect.left+self.rect.width < SCREEN_WIDTH:
                self.rect.left += self.speed
            else:
                # 修改子弹状态
                self.live = False

    def myBullet_hit_enemyTank(self):
        # 判断我方子弹是否射中敌方坦克
        for enemyTank in MainGame.enemyTankList:
            # 循环遍历敌方坦克
            if pygame.sprite.collide_rect(enemyTank, self):
                # 发生碰撞
                enemyTank.live = False
                self.live = False
                # 创建爆炸对象
                explode = Explode(enemyTank)
                # 将爆炸属性添加到爆炸列表中
                MainGame.explodeList.append(explode)

    def enemyBullet_hit_myTank(self):
        if MainGame.my_tank and MainGame.my_tank.live:
            # 敌方子弹与我方坦克碰撞
            if pygame.sprite.collide_rect(MainGame.my_tank, self):
                # 产生爆炸对象
                explode = Explode(MainGame.my_tank)
                # 将爆炸对象添加到爆炸列表中
                MainGame.explodeList.append(explode)
                # 修改敌方子弹与我方坦克的状态
                self.live = False
                MainGame.my_tank.live = False



class Explode():

    def __init__(self, tank):
        # 爆炸的位置由当前子弹打中的坦克位置决定
        self.rect = tank.rect
        self.images = [
            pygame.image.load('img/blast0.gif'),
            pygame.image.load('img/blast1.gif'),
            pygame.image.load('img/blast2.gif'),
            pygame.image.load('img/blast3.gif'),
            pygame.image.load('img/blast4.gif')
        ]
        # 爆炸效果图片索引
        self.step = 0
        self.image = self.images[self.step]
        # 图片是否加载
        self.live = True

    def displayExplode(self):
        # 根据索引获取爆炸图片
        if self.step < len(self.images):
            self.image = self.images[self.step]
            self.step += 1
            # 添加到主窗口
            MainGame.window.blit(self.image, self.rect)
        else:
            # 不再显示爆炸效果
            self.live = False
            self.step = 0

if __name__ == '__main__':
    MainGame().start_game()
