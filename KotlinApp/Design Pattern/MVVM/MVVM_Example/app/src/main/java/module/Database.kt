package module

import java.util.ArrayList

class Database {

    private lateinit var database: Database
    private var arrayList : ArrayList<Int> = ArrayList() // arraylist 초기화


    fun saveNumber(number: Int){
        arrayList.add(number)
    }

    fun  getAllNumber(): ArrayList<Int>{
        return  arrayList
    }

    fun removeNumber(){
        arrayList.clear()
    }

}
/* ArrayList를 하나 생성해서 번호를 저장하고, 이때까지 뽑은 번호를 다 보여줄 수 있게 만들었다.
그러기 위해 먼저 모듈에 숫자를 저장하는 함수를 하나 만들었고, ArrayList 전체를 반환하는 함수를 하나 만들었다.
그리고 삭제 기능까지.


 */