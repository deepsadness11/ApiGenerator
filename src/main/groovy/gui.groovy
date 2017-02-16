import javax.swing.JFrame

/**
 * Created by Administrator on 2017/2/15 0015.
 */
import groovy.swing.SwingBuilder

import java.awt.*
import java.awt.event.ActionEvent


def searchField
def resultsList


void show() {
    def swingBuilder = new SwingBuilder()

    def listPannel = {
        swingBuilder.comboBox(
                items:
                        ['阅读圈', '阅读家庭', '书架'],
                preferredSize: [20, 20],
                constraints: BorderLayout.NORTH,
                actionPerformed: {
                    ActionEvent event ->
                        println event.source.selectedItem

                })
    }


    def resultsPanel = {
        swingBuilder.scrollPane(constraints: BorderLayout.CENTER) {
            resultsList = list()
        }
    }

    def main = new getStarted()

    swingBuilder.frame(title: "Api 自动生成模型",
            defaultCloseOperation: JFrame.EXIT_ON_CLOSE,
            size: [400, 300],

            show: true) {
        gridLayout(cols: 3, rows: 4)
//        customMenuBar()
//        searchPanel()
//        resultsPanel()
        label(text: '<html>tips:<br>选择对应的模块，生成APiService文件.<br>生成的文件将在D盘的根目录下的gn文件夹中</html>')

        outLabel = label(constraints: BorderLayout.SOUTH, text: "OutPut:", size: [100, 200])

        def list = listPannel()

        button(text: '点击开始生成',
                actionPerformed: {
                    println list.selectedItem
                    try {
                        outLabel.text = '正在生成.....'
                        main.start(list.selectedItem.toString())
                        outLabel.text = "<html>生成成功！！<br>请在D盘的根目录下的gn文件夹中复制文件</html>"
                    } catch (Exception e) {
                        e.printStackTrace()
                        outLabel.text = "<html>发生错误<br> $e.message</html>"
                    }
                })
    }
}
