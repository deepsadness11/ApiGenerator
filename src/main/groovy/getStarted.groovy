import global.Config

/**
 * Created by Administrator on 2017/2/15 0015.
 */

static start(String type) {
    String ProJectAddress
    String ApiAddress
    switch (type){
        case '阅读圈':
            ProJectAddress=Config.API_PROJ_DEV_READER
            ApiAddress=Config.API_DATA_DEV_READER
            break
        case '阅读家庭':
            ProJectAddress=Config.API_PROJ_DEV_USER
            ApiAddress=Config.API_DATA_DEV_USER
            break
        case '书架':
            ProJectAddress=Config.API_PROJ_DEV_BOOKSHELF
            ApiAddress=Config.API_DATA_DEV_BOOKSHELF
            break
        default:
            throw new RuntimeException('no type matches!!')
    }
    ApiProjectGet.start(ProJectAddress)
    ApiGenerator.start(ApiAddress)
    println 'start!!'
}