package ch.unstable.ost.api.search.types

import ch.unstable.ost.api.base.AbstractConnectionDeserializer

object ConnectionDeserializer : AbstractConnectionDeserializer() {
    override val sectionsField = "legs"
}