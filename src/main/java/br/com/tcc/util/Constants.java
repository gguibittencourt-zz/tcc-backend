package br.com.tcc.util;

import br.com.tcc.dto.KnowledgeArea;
import br.com.tcc.dto.Question;
import br.com.tcc.dto.Result;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;

public class Constants {

    public static final String LOGIN_ERROR = "Usuário/senha incorreto";

    public static final Type PROCESS_LIST_TYPE = new TypeToken<Collection<Process>>() {
    }.getType();

    public static final Type KNOWLEDGE_AREA_LIST_TYPE = new TypeToken<Collection<KnowledgeArea>>() {
    }.getType();

    public static final Type RESULT_LIST_TYPE = new TypeToken<Collection<Result>>() {
    }.getType();

    public static final Type INTEGER_LIST_TYPE = new TypeToken<Collection<Integer>>() {
    }.getType();

    public static final Type QUESTION_LIST_TYPE = new TypeToken<Collection<Question>>() {
    }.getType();
}
