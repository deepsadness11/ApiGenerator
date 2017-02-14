package bean
/**
 * Created by Administrator on 2017/2/14 0014.
 */
class FieldParam {
    /**
     * group : Parameter
     * type : Integer
     * optional : false
     * field : content_id
     * description : <p>日记id</p>
     */
    String group;
    String type;
    boolean optional;
    String field;
    String description;

    @Override
    public String toString() {
        return """\
bean.FieldParam{
    group='$group',
    type='$type',
    optional=$optional,
    field='$field',
    description='$description'
}"""
    }
}
