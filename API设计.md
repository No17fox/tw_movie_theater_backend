### 1. 查询所有电影 / 根据名称查询电影 / 根据分类查询电影 / 根据关键字查询电影

- **URL:**  http://localhost:8080/movies

- **Method:**  GET

- **Params:**  

  ```json
  {
      "title": "", // 可选
      "genres": "" // 可选
  }
  ```

- **Response** 

  - Status: 200

  ```json
  [
    {
      "id": "1291545",
      "alt": "https://movie.douban.com/subject/1291545/",
      "year": "2003",
      "title": "大鱼",
      "rating": "8.7",
      "original_title": "Big Fish",
      "directors": "蒂姆·波顿",
      "casts": "伊万·麦克格雷格,阿尔伯特·芬尼,比利·克鲁德普",
      "genres": "剧情,家庭,奇幻",
      "image": "https://img3.doubanio.com/view/movie_poster_cover/spst/public/p692813374.jpg"
    },
    {
      "id": "1291546",
      "alt": "https://movie.douban.com/subject/1291546/",
      "year": "1993",
      "title": "霸王别姬",
      "rating": "9.5",
      "original_title": "霸王别姬",
      "directors": "陈凯歌",
      "casts": "张国荣,张丰毅,巩俐",
      "genres": "剧情,爱情,同性",
      "image": "https://img3.doubanio.com/view/movie_poster_cover/spst/public/p1910813120.jpg"
    }
  ]
  ```

### 2. 根据id查询电影

- **URL:**  <http://localhost:8080/movies/[id]>

- **Method:**  GET

- **Params:**  none

- **Response** 

  - Status: 200

  ```json
  {
      "id": "1291545",
      "alt": "https://movie.douban.com/subject/1291545/",
      "year": "2003",
      "title": "大鱼",
      "rating": "8.7",
      "original_title": "Big Fish",
      "directors": "蒂姆·波顿",
      "casts": "伊万·麦克格雷格,阿尔伯特·芬尼,比利·克鲁德普",
      "genres": "剧情,家庭,奇幻",
      "image": "https://img3.doubanio.com/view/movie_poster_cover/spst/public/p692813374.jpg"
  }
  ```

### 3. 查询所有电影分类

- **URL:**  http://localhost:8080/movies/genres

- **Method:**  GET

- **Params:**  none

- **Response** 

  - Status: 200

  ```json
  ["剧情","家庭","奇幻","冒险","动作","喜剧"]
  ```

