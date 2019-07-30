# 자바 리듬 게임

## 1.개요

  자바로 개발한 리듬 게임 "Dynamic Beat" 입니다.

  ### 시연 영상
  [![IMAGE ALT TEXT](https://img.youtube.com/vi/cENq6yrb0L0/0.jpg)](http://www.youtube.com/watch?v=cENq6yrb0L0 "어플 시연 영상")

## 2. 개발환경

  - OS : window10
  - 개발언어 : Java
  - Tool : eclipse (jdk-8u201)
  - 외부 라이브러리 :

  | <center>Tool</center> |<center>사용목적</center> |<center>Version</center> |
  |:--------------------:|:---------------------:|:-------------------:|
  | jlayer | 프로젝트 내에서 mp3 파일 실행을 위해  | 1.0.1 |

## 3. Apps View

  - Main

 ![main](https://user-images.githubusercontent.com/38533816/62166501-e496e180-b35b-11e9-97e5-5fdbd525dace.gif)
 
  게임을 실행하게되면 제일먼저 볼수 있는 화면. (게임의 모든 버튼은 Hover 될때, Click 될때의 효과음이 날수 있게 해주었다.)

  - 곡 선택 화면

  ![selectMusic](https://user-images.githubusercontent.com/38533816/62166826-b534a480-b35c-11e9-9a15-34faadaa1810.gif)

  양 옆에있는 화살표 버튼으로 곡을 선택할 수 있고 , 곡의 난이도를 조정할수 있고(Easy,Hard) 곡이 바뀔때마다 해당하는 노래의 하이라이트 부분을 들을수 있다.

  - 게임 플레이 화면

  ![game](https://user-images.githubusercontent.com/38533816/62166875-d2697300-b35c-11e9-84e0-cd3bf09b6d99.gif)

  곡에 따라 노트가 다르게 떨어지게 되고 Easy, Hard 모드에 따라 노드가 다르게 출력된다.

  - 노트 판정 기준

  ![note](https://user-images.githubusercontent.com/38533816/62166821-b2d24a80-b35c-11e9-8c3c-281f1da3c014.gif)
  
  keypress 이벤트를 발생했을때 현재 노트가 판정바에 도달하기전에 이벤트가 발생했는지, 노트와 판정바가 겹쳐졌을때 이벤트가 발생했는지, 판정바를 넘어가고 난 후 이벤트가 발생했는지를 알기위해 현재 노트의 y축 값을 기준으로 판단하여 y축 값에 맞는 결과를 Early,Miss,Good,Great,Perfect 로 출력한다.  
