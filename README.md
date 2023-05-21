# ✨ Pinterest

<img src="https://github.com/GOSOPT-CDS-TEAM7-DeskTop/Backend/assets/67463603/04e1e958-9249-401d-8952-759497666fe7" width="300"/>

> 32기 GO SOPT 합동 세미나 Pinterest

<hr>

## 🌸 Contributors 섭팟이들
|                             이동섭                             |                               정준서                        |
| :----------------------------------------------------------: | :----------------------------------------------------------: |
| <img src="https://github.com/GOSOPT-CDS-TEAM7-DeskTop/Backend/assets/67463603/3c92f168-1ff0-42a4-a91f-9fbd11189d35" width="300" height="265"/> | <img src="https://user-images.githubusercontent.com/72034311/202870052-6b0a0045-0edf-42b0-8e74-9653589f3e35.png" width="300" height="265"/>  |
|              [ddongseop](https://github.com/ddongseop)               |             [sunseo18](https://github.com/sunseo18)              |

<hr>

## ⭐️ Role

| 담당 역할                          | Role |
|:-------------------------------|:----:|
| 프로젝트 초기 세팅 후 푸시                | 이동섭  |
| .gitignore 설정                  | 이동섭  |
| DB 구축                          | 정준서  |
| ERD 작성                         | 정준서  |

<hr>

## 👻 API Docs

### 🔗 [API Docs](https://www.notion.so/go-sopt/9dfcad9aa11c46a3bd7fa9a0ecf87368?v=1aba2486dac34eecbb7b948313e68674&pvs=4)


## ⭐️ API 담당

| 이름                      | 담당 역할                          | Role |
|:------------------------|:-------------------------------|:----:|
| 게시글(핀) 전체 조회하기          | [GET] /pin                     | 정준서  |
| 게시글(핀) 검색하기             | [GET] /pin/?title={title}      | 정준서  |
| 게시글(핀) 상세보기             | [GET] /pin/:pinId              | 이동섭  |
| 게시글(핀) 저장하기             | [POST] /pin/save               | 정준서  |
| 게시글(핀) 생성하기             | [POST] /pin                    | 정준서  |
| 댓글 작성하기                 | [POST] /comment/:pinId         | 이동섭  |
| 유저 정보 조회                | [GET] /user                    | 이동섭  |
| 정리되지 않은 아이디어 조회         | [GET] /user/save               | 이동섭  |
| 팔로우하기                        | [POST] /user/follow            | 이동섭  |

<hr>

## 👉️ ERD
<img width="786" alt="KakaoTalk_Photo_2023-05-19-18-09-17" src="https://github.com/GOSOPT-CDS-TEAM7-DeskTop/Backend/assets/67463603/a1e273aa-8837-4221-8b7f-e22e1a23f3f7">

<hr>

## 👉 Project Structure

```
🗂 Pinterest
    🗂 common (공통 처리 관련 클래스)
        🗂 advice
        🗂 dto
    🗂 controller (클라이언트의 요청을 받는 컨트롤러 계층)
        🗂 dto
            🗂 request
            🗂 response
    🗂 domain (도메인)
    🗂 exception (예외처리)
        🗂 model
    🗂 infrastructure (데이터베이스 등 외부 요소와 연결을 수행하는 계층)
    🗂 service (비즈니스로직이 있는 서비스 계층)
```

# 🌱 Branch

<aside>

`main branch` : 배포 단위 branch

`develop branch` : 주요 개발 branch, main merge 전 거치는 branch

`feature branch`: 각자 개발 branch

-   API별로 feature breanch를 생성
    -   ex) feat/get_all_pins
    

-   해당 branch 작업 완료 후 PR 보내기
    -   항상 local에서 충돌 해결 후 → remote에 올리기
    -   reviewer에 서로 tag후 code-review
    -   comment 전 merge 불가!

</aside>

<hr>

# 🙏 Commit Convention

`ex) [Feat] 댓글 작성 API 기능 구현`

```
- Feat : 새로운 기능 구현
- Fix : 버그, 오류 해결
- Style : 코드가 아닌 스타일 변경을 하는 경우
- Refactor : 프로덕션 코드 리팩토링
- Docs : README나 WIKI 등의 문서 개정
- Chore : 코드 수정, 내부 파일 수정
- Rename : 파일 이름의 변경
- Add : Feat 이외의 부수적인 코드 추가, 라이브러리 추가, 새로운 파일 생성 시
- Del : 쓸모없는 코드 삭제
- Move : 프로젝트 내 파일이나 코드의 이동
- Merge: 다른브렌치를 merge하는 경우
- Init : Initial commit을 하는 경우
```

# 🙏 Code Convention

> 💡 **동료들과 말투를 통일하기 위해 컨벤션을 지정합니다.**
> 오합지졸의 코드가 아닌, **한 사람이 짠 것같은 코드**를 작성하는 것이 추후 유지보수나 협업에서 도움이 됩니다. 내가 코드를 생각하면서 짤 수 있도록 해주는 룰이라고 생각해도 좋습니다!

<details>
<summary>명명규칙(Naming Conventions)</summary>
<div markdown="1">

1. 이름으로부터 의도가 읽혀질 수 있게 쓴다.

-   ex)

    ```jsx
    // bad
    function q() {
        // ...stuff...
    }

    // good
    function query() {
        // ..stuff..
    }
    ```

2. 오브젝트, 함수, 그리고 인스턴스에는 `camelCase`를 사용한다.

-   ex)
    ```jsx
    // bad
    const OBJEcttsssss = {};
    const this_is_my_object = {};
    function c() {}

    // good
    const thisIsMyObject = {};
    function thisIsMyFunction() {}
    ```

3. 클래스나 constructor에는 `PascalCase`를 사용한다.

-   ex)
    ```jsx
    // bad
    function user(options) {
        this.name = options.name;
    }

    const bad = new user({
        name: 'nope',
    });

    // good
    class User {
        constructor(options) {
            this.name = options.name;
        }
    }

    const good = new User({
        name: 'yup',
    });
    ```

4. 함수 이름은 동사 + 명사 형태로 작성한다.
   ex) `postUserInformation( )`
5. 약어 사용은 최대한 지양한다.
6. 이름에 네 단어 이상이 들어가면 팀원과 상의를 거친 후 사용한다
 </div>
 </details>

<details>
<summary>블록(Blocks)</summary>
<div markdown="1">

1. 복수행의 블록에는 중괄호({})를 사용한다.

-   ex)
    ```jsx
    // bad
    if (test)
      return false;

    // good
    if (test) return false;

    // good
    if (test) {
      return false;
    }

    // bad
    function() { return false; }

    // good
    function() {
      return false;
    }

    ```

2. 복수행 블록의 `if` 와 `else` 를 이용하는 경우 `else` 는 `if` 블록 끝의 중괄호( } )와 같은 행에 위치시킨다.

-   ex)
    ```java
    // bad
    if (test) {
    thing1();
    thing2();
    }
    else {
    thing3();
    }

    // good
    if (test) {
      thing1();
      thing2();
    } else {
      thing3();
    }

    ```
</div>
</details>

<details>
<summary>코멘트(Comments)</summary>
<div markdown="1">

1. 복수형의 코멘트는 `/** ... */` 를 사용한다.

-   ex)
    ```jsx
    // good
    /**
     * @param {String} tag
     * @return {Element} element
     */
    
    function make(tag) {
        // ...stuff...

        return element;
    }
    ```

2. 단일 행의 코멘트에는 `//` 을 사용하고 코멘트를 추가하고 싶은 코드의 상부에 배치한다. 그리고 코멘트의 앞에 빈 행을 넣는다.

-   ex)
    ```jsx
    // bad
    const active = true; // is current tab

    // good
    // is current tab
    const active = true;

    // good
    function getType() {
        console.log('fetching type...');

        // set the default type to 'no type'
        const type = this._type || 'no type';

        return type;
    }

    ```
</div>
</details>
