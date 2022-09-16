package viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import module.Database
import java.util.*
import kotlin.collections.ArrayList

class MainViewModel  : ViewModel() {

    private val database: Database = Database()
    private var rand = Random()

    var nowNum = -1

    companion object{
        var MaxNum = 101
    }

    var text: MutableLiveData<String>  = MutableLiveData()

    init {
        text.value = ""
    }

    fun getNum() {
        nowNum = rand.nextInt(MaxNum) + 1
        database.saveNumber(nowNum)
        text.value = nowNum.toString()
    }

    fun setMaxNum(int: Int?){
        println(int)
        MaxNum = int!!
    }

    fun showAllNum(){
        if (nowNum == -1)
            return

        text.value = ""
        var array: ArrayList<Int> = ArrayList()

        array = database.getAllNumber()

        for (i in 0 until  array.size) {
            text.value += array.get(i).toString() + " "
        }

        println(text)

    }
}
/*
데이터베이스를 인스턴스 시켰고, 값을 랜덤 하게 뽑아야 하기 때문에 Random함수를 불러와 줬다.
지금 번호는 먼저 -1로 정해두었고 -1인 상태에서 내가 뽑은 수 전부 보기를 누르면 아무것도 나오지 않게 만들었다.
그다음 최대수는 companion object로 static 상태로 만들어 주었다.
마지막으로 표시할 text를 livedata로 만들었다.
*/