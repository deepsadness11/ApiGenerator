/**
 * Created by Administrator on 2017/2/15 0015.
 */
import groovy.swing.SwingBuilder
import java.awt.event.*
import javax.swing.event.*
import javax.swing.WindowConstants as WC

SwingBuilder.build() {
    frame(title:'自动生成Service插件', size:[500,700],
            visible:true, defaultCloseOperation:WC.EXIT_ON_CLOSE) {
        //需要进行选择，或者进行输入。输入的话。需要一行
        //输入需要包名。和文件路径

        gridLayout(cols: 3, rows: 5)
        label 'Input text: '
        input = textField(columns:5, actionPerformed: { echo.text = input.text.toUpperCase() })
        label 'Echo: '
        echo = label()
        input.document.addDocumentListener(
                [insertUpdate: { echo.text = input.text },
                 removeUpdate: { echo.text = input.text },
                 changedUpdate: { e -> println e }] as DocumentListener)

        input.addFocusListener(
                [focusGained: { e -> println "Focus gained: $e.cause"},
                 focusLost: {e -> println "Focus lost: $e.cause"}] as FocusListener)

        input.addCaretListener({ e ->  println "Caret event: $e"})
    }
}