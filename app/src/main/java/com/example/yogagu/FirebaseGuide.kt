package com.example.yogagu

class FirebaseGuide {
    var id: String? = null
    @kotlin.jvm.JvmField
    var title: String? = null
    @kotlin.jvm.JvmField
    var description: String? = null

    constructor() {}
    constructor(id: String?, title: String?, description: String?) {
        this.id = id
        this.title = title
        this.description = description
    }
}