enum class CalcOperation: IOperationArgCount {
    SUM {
        override fun getOperationArgCount() = 2
    },
    MINUS {
        override fun getOperationArgCount() = 2
    },
    DIV {
        override fun getOperationArgCount() = 2
    },
    MULTIPLE {
        override fun getOperationArgCount() = 2
    },
    PERCENT {
        override fun getOperationArgCount() = 2
    },
    SQUARE {
        override fun getOperationArgCount() = 1
    }
}