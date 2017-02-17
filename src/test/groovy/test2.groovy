import com.squareup.javapoet.ClassName
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.TypeSpec
import util.GPoetUtil

/**
 * Created by Administrator on 2017/2/17 0017.
 */
//TypeSpec ts = TypeSpec.interfaceBuilder("Example")
//        .addSuperInterface(ClassName.get("org.pack", "Example")).build();
//System.out.println(JavaFile.Builder("com.ex", ts).build().toString());

ClassName a = ClassName.get("org.pack", "Example")
TypeSpec ts=TypeSpec.classBuilder("Cla").addSuperinterface(a).build()
GPoetUtil.print2Out("",ts)