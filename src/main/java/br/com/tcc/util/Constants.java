package br.com.tcc.util;

import br.com.tcc.dto.KnowledgeArea;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;

public class Constants {

    public static final String LOGIN_ERROR = "Usuário/senha incorreto";

    public static final Type PROCESS_LIST_TYPE = new TypeToken<Collection<Process>>() {
    }.getType();

    public static final Type KNOWLEDGE_AREA_LIST_TYPE = new TypeToken<Collection<KnowledgeArea>>() {
    }.getType();
}
