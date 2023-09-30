fun main() {
    println("output -> ${doJob("ဟိပ်ဂျစ်ထယ်ဠာ")}")
}

fun doJob(input: String): String{
    val indexes = hashMapOf<Int,Int>()
    val alphabets = getAllMyanmarAlphabets()

    input.toCharArray().mapIndexed{ index, c ->
        if (c.toString() in alphabets && (input.toCharArray().get(index + 1) != '်')) indexes.put(index,alphabets.indexOf(c.toString()))
    }

    val stringBuilder = StringBuilder(input)
    println("input -> $input")
    indexes.map {
        stringBuilder.setCharAt(it.key, alphabets.get(it.value - 1).toCharArray().get(0)).toString()
    }

    return stringBuilder.toString()
}

fun getAllMyanmarAlphabets(): List<String>{
    val list = mutableListOf<String>()

    for (code in 0x1000..0x1021){
        list.add(("\\u${code.toString(16).padStart(4,'0')}").toCharacter())
    }
    return list
}

fun String.toCharacter(): String{
    val code = this.drop(2).toInt(16)
    return code.toChar().toString()
}